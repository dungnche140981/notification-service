package vn.fpt.edu.notification.entity;

import javax.persistence.*;
import lombok.*;
import org.springframework.context.event.EventListener;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 11/04/2023 - 21:29
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
@Entity
@Table(name = "notification_history")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class NotificationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String title;
    @Column(length = 1000)
    private String message;
    private String image;
    private Long connectorId;
    private Boolean status;
    @Builder.Default
    private Boolean isRead = false;
    @CreatedDate
    private LocalDateTime createdDate;
}
