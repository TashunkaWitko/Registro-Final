package it.pi.registro.registro.service.impl;

import it.pi.registro.registro.configuration.RegistroProp;
import it.pi.registro.registro.service.ApiLogService;
import it.pi.registro.registro.service.ScheduledService;
import it.pi.registro.registro.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ScheduledServiceImpl implements ScheduledService {

    @Autowired
    ApiLogService apiLogService;

    @Autowired
    private RegistroProp registroProp;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void createReport() {
        System.out.println("");
        System.out.println(jwtUtil.generateToken());
    }

    @Override
    public String getUsersFromExternalAPIs() {
        try {
            LocalDateTime requestDate = LocalDateTime.now();
            final String externalAPI = registroProp.getNodeAPI();
            RestTemplate restTemplate = new RestTemplate();

            String plainCreds = "test:test";
            byte[] plainCredsBytes = plainCreds.getBytes();
            byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes,true);
            String base64Creds = new String(base64CredsBytes);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Creds);

            HttpEntity<String> request = new HttpEntity<String>(headers);
            ResponseEntity<?> response = restTemplate.exchange(externalAPI, HttpMethod.GET, request, String.class);
            //String result = restTemplate.getForObject(externalAPI, String.class);
            apiLogService.saveExternalLog(requestDate, externalAPI);
            return "200 OK";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
