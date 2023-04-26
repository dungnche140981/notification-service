package vn.fpt.edu.notification.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 12/04/2023 - 01:57
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
@Entity
@Table(name = "notification_counters")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class NotificationCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    @Builder.Default
    private Integer count = 0;
}
