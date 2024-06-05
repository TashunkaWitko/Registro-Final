package it.pi.registro.registro.controller.api;

import it.pi.registro.registro.dto.request.CsvImportRequestDTO;
import it.pi.registro.registro.dto.request.UserRegisterRequest;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.service.ApiLogService;
import it.pi.registro.registro.service.AuthService;
import it.pi.registro.registro.service.ImportService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/import")
public class ImportController {

    private ImportService importService;

    private ApiLogService apiLogService;

    @PostMapping("/csv")
    public ResponseEntity<?> importCsv(@Valid @RequestBody CsvImportRequestDTO csvImportRequestDTO){

        importService.importCsv(csvImportRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
