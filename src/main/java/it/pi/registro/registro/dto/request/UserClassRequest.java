package it.pi.registro.registro.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserClassRequest {

    @NotBlank
    @Email
    private String teacherEmail;

    private String className;

    @Override
    public String toString() {
        return "UserClassRequest{" +
                "teacherEmail='" + teacherEmail + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
