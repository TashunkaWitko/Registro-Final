package it.pi.registro.registro.dto.request;

import it.pi.registro.registro.annotation.AgeConstraint;
import it.pi.registro.registro.annotation.ValidPassword;
import it.pi.registro.registro.entity.UserType;
import it.pi.registro.registro.enums.UserTypeEnum;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {

    @NotBlank
    private String firstName;
    @Size(min = 3)
    private String lastName;
    @Email
    private String email;
    @AgeConstraint
    @Past
    private LocalDate dateOfBirth;
    @NotBlank
    // @Pattern(regexp = )
    @ValidPassword
    private String password;
    @NotBlank
    @Size(min = 10, max = 50)
    private String address;
    @NotBlank
    @Size(min = 3, max = 30)
    private String city;

    private UserTypeEnum type;

}
