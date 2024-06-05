package it.pi.registro.registro.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CsvImportRequestDTO {

    @NotBlank
    private String base64File;

    @NotBlank
    private String fileName;

    @Override
    public String toString() {
        return "CsvImportRequestDTO{" +
                "base64File='" + base64File + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
