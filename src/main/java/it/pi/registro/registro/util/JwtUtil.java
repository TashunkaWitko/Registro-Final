package it.pi.registro.registro.util;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import it.pi.registro.registro.configuration.RegistroProp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Autowired
    private RegistroProp registroProp;

    public String generateToken(){
        return Jwts.builder(

        ).setSubject(registroProp.getSubject())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + registroProp.getExpireDate()))
                .signWith(SignatureAlgorithm.HS256, registroProp.getBase())
                .compact();
    }
}
