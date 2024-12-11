package com.logistics.platform.deliverymanagerservice.presentation.controller;

import com.logistics.platform.deliverymanagerservice.application.service.DeliveryManagerService;
import com.logistics.platform.deliverymanagerservice.presentation.global.ResponseDto;
import com.logistics.platform.deliverymanagerservice.presentation.request.DeliveryManagerRequestDto;
import com.logistics.platform.deliverymanagerservice.presentation.request.DeliveryManagerUpdateRequestDto;
import com.logistics.platform.deliverymanagerservice.presentation.response.DeliveryManagerResponseDto;
import com.querydsl.core.types.Predicate;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/delivery-managers")
public class DeliveryManagerController {

  private final DeliveryManagerService deliveryManagerService;

  // 배송담당자 생성
  @PostMapping
  public ResponseDto<DeliveryManagerResponseDto> createDeliveryManager(
      @RequestBody DeliveryManagerRequestDto deliveryManagerRequestDto) {

    DeliveryManagerResponseDto deliveryManagerResponseDto = deliveryManagerService.createDeliveryManager(deliveryManagerRequestDto);

    return new ResponseDto<>(ResponseDto.SUCCESS, "배송담당자가 생성되었습니다.", deliveryManagerResponseDto);
  }

  // 배송담당자 조회
  @GetMapping("/{deliveryManagerId}")
  public ResponseDto<DeliveryManagerResponseDto> getDeliveryManager(@PathVariable UUID deliveryManagerId) {

    DeliveryManagerResponseDto deliveryManagerResponseDto = deliveryManagerService.getDeliveryManager(deliveryManagerId);

    return new ResponseDto<>(ResponseDto.SUCCESS, "배송담당자가 조회되었습니다.", deliveryManagerResponseDto);
  }

  // 배송담당자 목롣 조회
  @GetMapping
  public ResponseDto<PagedModel<DeliveryManagerResponseDto>> getDeliveryManagersPage(
      @RequestParam(required = false) List<UUID> uuidList,
      @RequestParam(required = false) Predicate predicate,
      Pageable pageable) {

    PagedModel<DeliveryManagerResponseDto> deliveryManagerResponseDtoPage
        = deliveryManagerService.getDeliveryManagersPage(uuidList, predicate, pageable);

    return new ResponseDto<>(ResponseDto.SUCCESS, "배송담당자 목록이 조회되었습니다.", deliveryManagerResponseDtoPage);
  }


  // 배송담당자 수정
  @PatchMapping("/{deliveryManagerId}")
  public ResponseDto<DeliveryManagerResponseDto> updateDeliveryManager(
      @PathVariable UUID deliveryManagerId,
      @RequestBody DeliveryManagerUpdateRequestDto deliveryManagerUpdateRequestDto) {

    DeliveryManagerResponseDto deliveryManagerResponseDto = deliveryManagerService.updateDeliveryManager(deliveryManagerId, deliveryManagerUpdateRequestDto);

    return new ResponseDto<>(ResponseDto.SUCCESS, "배송담당자가 수정되었습니다.", deliveryManagerResponseDto);
  }


  // 배송담당자 삭제
  @DeleteMapping("/{deliveryManagerId}")
  public ResponseDto<DeliveryManagerResponseDto> deleteDeliveryManager(
      @PathVariable UUID deliveryManagerId,
      @RequestHeader("deletedBy") String deletedBy) {

    DeliveryManagerResponseDto deliveryManagerResponseDto = deliveryManagerService.deleteDeliveryManager(deliveryManagerId, deletedBy);

    return new ResponseDto<>(ResponseDto.SUCCESS, "배송담당자가 삭제되었습니다.", deliveryManagerResponseDto);
  }

}
