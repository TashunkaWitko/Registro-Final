package it.pi.registro.registro.service;

import org.springframework.http.ResponseEntity;

public interface ScheduledService {
    void jwtApi();

    ResponseEntity<?> BasicAuthApi();
}
