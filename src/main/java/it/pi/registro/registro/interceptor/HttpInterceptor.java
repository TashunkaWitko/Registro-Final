package it.pi.registro.registro.interceptor;

import it.pi.registro.registro.configuration.ApiProp;
import it.pi.registro.registro.configuration.RegistroProp;
import it.pi.registro.registro.entity.ApiKey;
import it.pi.registro.registro.entity.ApiLog;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.exception.ApiValidationException;
import it.pi.registro.registro.repository.ApikeyRepository;
import it.pi.registro.registro.service.ImportService;
import it.pi.registro.registro.service.impl.ApiLogServiceImpl;
import it.pi.registro.registro.service.impl.ImportServiceImpl;
import it.pi.registro.registro.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;
import java.util.List;

public class HttpInterceptor implements HandlerInterceptor {

    private final ImportServiceImpl importService;


    public HttpInterceptor(ImportServiceImpl importService){
        this.importService=importService;

    }
    private RegistroProp registroProp;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
            throws Exception {
        response.addHeader("Custom-Header", "Value");
        String key = request.getHeader("apikey");
        return importService.checkApiKey(key, request.getRequestURI());
        //throw new ApiValidationException("Unauthorized");
    }
}
