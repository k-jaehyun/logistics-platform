package com.logistics.platform.hub_service.domain.repository;

import com.logistics.platform.hub_service.domain.model.Hub;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HubRepository extends JpaRepository<Hub, UUID> {

  Optional<Hub> findByHubNameAndIsDeletedFalse(String hubName);

  Page<Hub> findAllByHubNameContainsIgnoreCaseAndIsDeletedFalse(String hubName, Pageable pageable);

  Optional<Hub> findByHubIdAndIsDeletedFalse(UUID hubId);

  Page<Hub> findAllByIsDeletedFalse(Pageable pageable);
}
