package com.logistics.platform.hub_service.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "p_hub")
public class Hub {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID hubId;

  @Column(nullable = false)
  private String hubName;

  @Column(nullable = false)
  private String address;

  @Column(nullable = false)
  private double latitude;

  @Column(nullable = false)
  private double longitude;

  @Column(columnDefinition = "geometry(Point, 4326)", nullable = false)
  private Point location;

  // todo 생성일 ~ 삭제자

  @Column(nullable = false)
  private boolean isDeleted;

}
