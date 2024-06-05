package it.pi.registro.registro.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserVotesRequestDTO {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @NotNull(message = "No User ID")
    private Long userId;

}
