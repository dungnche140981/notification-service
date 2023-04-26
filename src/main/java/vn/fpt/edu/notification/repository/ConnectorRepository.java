package vn.fpt.edu.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fpt.edu.notification.entity.Connector;

import java.util.Optional;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 11/04/2023 - 21:32
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
@Repository
public interface ConnectorRepository extends JpaRepository<Connector, Long> {

    Optional<Connector> findByCode(String code);
}
