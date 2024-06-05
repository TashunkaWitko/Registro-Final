package it.pi.registro.registro.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;

import java.text.SimpleDateFormat;

@Entity
@Table(name = "user_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String address;
    @Column
    private String city;

    public UserDetail(String address, String city) {
        this.address = address;
        this.city = city;
    }

    //    @OneToOne(mappedBy = "userDetail")
//    private User user;
}
