package it.pi.registro.registro.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "apilogs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApiLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String urlCalled;

    @Column
    private String callerIp;

    @Column
    private LocalDateTime requestDate;

    @Column
    private LocalDateTime responseDate;

    @Column
    private String base64;

    public ApiLog(String urlCalled, String callerIp, LocalDateTime callDate, LocalDateTime responseDate, String base64) {
        this.urlCalled=urlCalled;
        this.callerIp=callerIp;
        this.requestDate=callDate;
        this.responseDate=responseDate;
        this.base64=base64;
    }
}
