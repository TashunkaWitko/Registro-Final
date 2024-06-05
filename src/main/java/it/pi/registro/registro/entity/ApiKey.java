package it.pi.registro.registro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "apikeys")
@NoArgsConstructor
@Getter
@Setter
public class ApiKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime initialDate;

    @Column
    private LocalDateTime expireDate;

    @Column
    private String apiKey;

    @Column
    private String description;

    @Override
    public String toString() {
        return "ApiKey{" +
                "id=" + id +
                ", initialDate=" + initialDate +
                ", expireDate=" + expireDate +
                ", apiKey='" + apiKey + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
