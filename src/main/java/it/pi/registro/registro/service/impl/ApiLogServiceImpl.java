package it.pi.registro.registro.service.impl;

import it.pi.registro.registro.entity.ApiLog;
import it.pi.registro.registro.repository.ApilogsRepository;
import it.pi.registro.registro.service.ApiLogService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Builder
public class ApiLogServiceImpl implements ApiLogService {

    @Autowired
    private ApilogsRepository apilogsRepository;

    @Override
    public ApiLog saveLog(ApiLog apiLog) {
        return apilogsRepository.save(apiLog);
    }
}
