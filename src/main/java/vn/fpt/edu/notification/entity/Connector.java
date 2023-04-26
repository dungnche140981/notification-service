package vn.fpt.edu.notification.entity;

import javax.persistence.*;
import lombok.*;

/**
 * @author : Cong Dung
 * @product : Horo System
 * @project : Notification Service
 * @created : 11/04/2023 - 21:14
 * @contact : 0339850697 - congdung2510@gmail.com
 **/
@Entity
@Table(name = "connectors")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Connector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    @Column(length = 4000)
    private String sdkConfiguration;
}
