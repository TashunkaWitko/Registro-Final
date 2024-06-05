package it.pi.registro.registro.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.pi.registro.registro.dto.request.CsvImportRequestDTO;
import it.pi.registro.registro.entity.ApiLog;
import it.pi.registro.registro.repository.ApilogsRepository;
import it.pi.registro.registro.service.ApiLogService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Builder
public class ApiLogServiceImpl implements ApiLogService {

    @Autowired
    private ApilogsRepository apilogsRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void saveLog(CsvImportRequestDTO csvImportRequestDTO,
                        HttpServletRequest httpServletRequest,
                        String httpServletResponse,
                        int httpStatusCode,
                        LocalDateTime requestDate,
                        LocalDateTime responseDate) {
        ApiLog apiLog;
        try {
            apiLog = new ApiLog(
                    "127.0.0.1",
                    httpServletRequest.getRequestURI(),
                    requestDate,
                    responseDate,
                    httpServletRequest.getMethod(),
                    objectMapper.writeValueAsString(csvImportRequestDTO),
                    httpStatusCode,
                    httpServletResponse
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        apilogsRepository.save(apiLog);
    }
}
