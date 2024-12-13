package com.logistics.platform.slack_service.domain.repository;

import com.logistics.platform.slack_service.domain.model.Slack;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlackRepository extends JpaRepository<Slack, UUID> {

}
