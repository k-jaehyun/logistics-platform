package com.logistics.platform.hub_service.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

  private String hubName;

  // todo 생성일 ~ 삭제자

  private boolean isDeleted;

}
