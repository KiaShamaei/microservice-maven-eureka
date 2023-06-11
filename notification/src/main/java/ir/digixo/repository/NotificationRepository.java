package ir.digixo.repository;

import ir.digixo.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationEntity , Long> {
}
