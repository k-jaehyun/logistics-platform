package com.logistics.platform.delivery_service.delivery.domain.model;


import com.logistics.platform.delivery_service.delivery.presentation.request.DeliveryRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "p_delivery")
public class Delivery extends AuditingFields{

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private Long userId;

  @Column(nullable = false)
  private UUID startHubId;

  @Column(nullable = false)
  private UUID endHubId;

  @Column(nullable = false)
  private UUID orderId;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private DeliveryStatus deliveryStatus;

  @Column(nullable = false, length = 100)
  private String recipient;

  @Column(nullable = false, length = 100)
  private String recipientSlackId;

  @Column(nullable = false, length = 255)
  private String address;

  @Column(nullable = false)
  private Boolean isDeleted = false;

  @Builder
  public Delivery(Long userId, UUID startHubId, UUID endHubId, UUID orderId, DeliveryStatus deliveryStatus, String recipient, String recipientSlackId, String address, Boolean isDeleted) {
    this.userId = userId;
    this.startHubId = startHubId;
    this.endHubId = endHubId;
    this.orderId = orderId;
    this.deliveryStatus = deliveryStatus;
    this.recipient = recipient;
    this.recipientSlackId = recipientSlackId;
    this.address = address;
    this.isDeleted = isDeleted;
  }

  public void updateDelivery(DeliveryRequestDto deliveryRequestDto) {
    this.startHubId = deliveryRequestDto.getStartHubId();
    this.endHubId = deliveryRequestDto.getEndHubId();
    this.orderId = deliveryRequestDto.getOrderId();
    this.deliveryStatus = deliveryRequestDto.getDeliveryStatus();
    this.recipient = deliveryRequestDto.getRecipient();
    this.recipientSlackId = deliveryRequestDto.getRecipientSlackId();
    this.address = deliveryRequestDto.getAddress();
  }

  // 배송수정으로 상태 업데이트 말고 배송완료 메서드가 따로 필요하지 않을까 해서 만들어 본 것
  public void completeDelivery(String completedBy) {
    this.deliveryStatus = DeliveryStatus.DELIVERY_COMPLETED;
    super.complete(completedBy);
  }


  // 배송삭제와 배송취소가 분리되어서 필요할 것으로 보여서 만들어 둠
  public void cancelDelivery(String cancelledBy) {
    this.deliveryStatus = DeliveryStatus.DELIVERY_CANCELLED;
    super.cancel(cancelledBy);
  }


  public void deleteDelivery(String deletedBy) {
    this.deliveryStatus = DeliveryStatus.DELIVERY_DELETED;
    super.delete(deletedBy);
  }

}
