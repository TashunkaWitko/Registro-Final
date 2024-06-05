package it.pi.registro.registro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "user_type")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Il nome non può essere vuoto")
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String description;

}

