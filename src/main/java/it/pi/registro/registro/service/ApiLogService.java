package it.pi.registro.registro.service;

import it.pi.registro.registro.dto.request.CsvImportRequestDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public interface ApiLogService {
    void saveLog(CsvImportRequestDTO csvImportRequestDTO,
                 HttpServletRequest httpServletRequest,
                 String httpServletResponse,
                 int httpStatusCode,
                 LocalDateTime requestDate,
                 LocalDateTime responseDate) ;
}
