package com.logistics.platform.product_service.application.service;

import com.logistics.platform.product_service.domain.model.Product;
import com.logistics.platform.product_service.domain.repository.ProductRepository;
import com.logistics.platform.product_service.presentation.global.exception.CustomApiException;
import com.logistics.platform.product_service.presentation.request.ProductRequestDto;
import com.logistics.platform.product_service.presentation.response.ProductResponseDto;
import com.querydsl.core.types.Predicate;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;


  public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {

    // TODO companyId 검증

    // TODO hubId 검증

    // 상품명 중복 가능

    Product product = Product.builder()
        .productName(productRequestDto.getProductName())
        .price(productRequestDto.getPrice())
        .count(productRequestDto.getCount())
        .createdBy("생성자") // TODO 생성자 추가
        .companyId(productRequestDto.getCompanyId())
        .hubId(productRequestDto.getHubId())
        .build();

    product = productRepository.save(product);

    return new ProductResponseDto(product);
  }

  @Transactional(readOnly = true) // TODO Caching
  public ProductResponseDto getProduct(UUID productId) {

    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new CustomApiException("존재하지 않는 productId 입니다."));

    if (product.getIsDeleted()) {
      throw new CustomApiException("이미 삭제된 상품입니다.");
    }

    return new ProductResponseDto(product);
  }

  @Transactional(readOnly = true) // TODO Caching
  public PagedModel<ProductResponseDto> getProductsPage(
      List<UUID> uuidList, Predicate predicate, Pageable pageable) {

    Page<ProductResponseDto> productResponseDtoPage
        = productRepository.findAll(uuidList, predicate, pageable);

    return new PagedModel<>(productResponseDtoPage);
  }

  @Transactional
  @CacheEvict(value = "productPriceCache", key = "#productId")
  public ProductResponseDto updateProduct(UUID productId, ProductRequestDto productRequestDto) {

    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new CustomApiException("존재하지 않는 productId입니다."));

    if (product.getIsDeleted()) {
      throw new CustomApiException("이미 삭제된 상품입니다.");
    }

    product.update(productRequestDto); // TODO 수정자 추가

    return new ProductResponseDto(product);
  }

  @Transactional
  @Caching(evict = {
      @CacheEvict(value = "productValidationCache", key = "#productId"),
      @CacheEvict(value = "productPriceCache", key = "#productId")
  })
  public ProductResponseDto deleteProduct(UUID productId) {

    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new CustomApiException("존재하지 않는 productId입니다."));

    if (product.getIsDeleted()) {
      throw new CustomApiException("이미 삭제된 상품입니다.");
    }

    product.delete(); // TODO 삭제자 추가

    return new ProductResponseDto(product);
  }

  public Boolean validateProductId(UUID productId) {
    return productRepository.findById(productId)
        .map(product -> !product.getIsDeleted())  // Optional이 비어 있지 않다면, map 안의 람다식 실행
        .orElse(false);
  }

  public Long getProductPriceById(UUID productId) {
    return productRepository.findById(productId).orElseThrow().getPrice();
  }
}
