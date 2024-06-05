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
    private String callerIp;

    @Column
    private String urlCalled;

    @Column
    private LocalDateTime requestDate;

    @Column(nullable = true)
    private LocalDateTime responseDate;

    @Column
    private String httpRequestMethod;

    @Column(length = 10000)
    private String httpRequestBody;

    @Column
    private int httpResponseCode;

    @Column
    private String httpResponseMessage;

    public ApiLog(String callerIp, String urlCalled, LocalDateTime requestDate, LocalDateTime responseDate, String httpRequestMethod, String httpRequestBody, int httpResponseCode, String httpResponseMessage) {
        this.callerIp=callerIp;
        this.urlCalled = urlCalled;
        this.requestDate = requestDate;
        this.responseDate = responseDate;
        this.httpRequestMethod = httpRequestMethod;
        this.httpRequestBody = httpRequestBody;
        this.httpResponseCode = httpResponseCode;
        this.httpResponseMessage = httpResponseMessage;
    }
}
