package it.pi.registro.registro.service;

import it.pi.registro.registro.dto.request.CsvImportRequestDTO;
import it.pi.registro.registro.dto.request.UserRegisterRequest;
import it.pi.registro.registro.entity.ApiKey;
import it.pi.registro.registro.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImportService {

    void importCsv(CsvImportRequestDTO csvImportRequestDTO);

    boolean checkApiKey(String apiKey, String URI);

    List<User> getusers();
}
