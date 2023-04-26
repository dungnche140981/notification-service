package vn.fpt.edu.notification.entity;

import javax.persistence.*;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 11/04/2023 - 21:11
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
@Entity
@Table(name = "device_tokens")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DeviceToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String token;
}
