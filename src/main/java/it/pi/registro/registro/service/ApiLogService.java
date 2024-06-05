package it.pi.registro.registro.service;

import it.pi.registro.registro.entity.ApiLog;
import org.springframework.stereotype.Service;

@Service
public interface ApiLogService {
    ApiLog saveLog(ApiLog apiLog);
}
