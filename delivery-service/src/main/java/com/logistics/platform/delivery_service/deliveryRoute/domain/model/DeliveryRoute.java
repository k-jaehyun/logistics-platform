package com.logistics.platform.delivery_service.deliveryRoute.domain.model;


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
@Table(name = "p_delivery_route")

public class DeliveryRoute extends AuditingFields{

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private UUID deliveryId;

  @Column(nullable = false)
  private UUID startHubId;

  @Column(nullable = false)
  private UUID endHubId;

  @Column(nullable = false)
  private UUID deliveryManagerId;

  @Column(nullable = false)
  private Long estimatedDuration;

  @Column(nullable = false)
  private Long estimatedDistance;

  @Column
  private Long actualDuration;

  @Column
  private Long actualDistance;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private DeliveryRouteStatus status;

  @Column(nullable = false, length = 255)
  private Long sequence;

  @Column(nullable = false)
  private Boolean isDeleted = false;

  @Builder
  public DeliveryRoute(UUID deliveryId, UUID startHubId, UUID endHubId, UUID deliveryManagerId,
      Long estimatedDuration, Long estimatedDistance, DeliveryRouteStatus status, Long sequence, Boolean isDeleted) {
    this.deliveryId = deliveryId;
    this.startHubId = startHubId;
    this.endHubId = endHubId;
    this.deliveryManagerId = deliveryManagerId;
    this.estimatedDuration = estimatedDuration;
    this.estimatedDistance = estimatedDistance;
    this.status = status;
    this.sequence = sequence;
    this.isDeleted = isDeleted;
  }

  public void updateActualMetrics(Long actualDuration, Long actualDistance) {
    this.actualDuration = actualDuration;
    this.actualDistance = actualDistance;
  }

  public void updateStatus(DeliveryRouteStatus status) {
    this.status = status;
  }

  public void deleteDeliveryRoute(String deletedBy) {
    this.status = DeliveryRouteStatus.DELETED;
    super.delete(deletedBy);
  }

}