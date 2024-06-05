package it.pi.registro.registro.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserNameRequest {

    @NotBlank
    @Size(min = 3)
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "String must not contain special characters")
    private String name;

    private Boolean isCaseSensitive = true;

}
