package it.pi.registro.registro.controller.api;

import it.pi.registro.registro.dto.request.CsvImportRequestDTO;
import it.pi.registro.registro.dto.request.UserRegisterRequest;
import it.pi.registro.registro.entity.ApiLog;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.service.ApiLogService;
import it.pi.registro.registro.service.AuthService;
import it.pi.registro.registro.service.ImportService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
@RequestMapping("api/import")
public class ImportController {

    private ImportService importService;

    private HttpServletRequest httpServletRequest;

    private HttpServletResponse httpServletResponse;

   // ApiLog apilog = new ApiLog().builder().requestDate(LocalDateTime.now()).responseDate(null).base64(null).urlCalled(null).build();

    @PostMapping("/csv")
    public ResponseEntity<?> importCsv(@Valid @RequestBody CsvImportRequestDTO csvImportRequestDTO){

        LocalDateTime requestDate = LocalDateTime.now();
        importService.importCsv(csvImportRequestDTO,
                httpServletRequest,
                requestDate,
                LocalDateTime.now());
        return new ResponseEntity<>(HttpStatus.valueOf(httpServletResponse.getStatus()));
    }
}
