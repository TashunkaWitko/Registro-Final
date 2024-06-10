package it.pi.registro.registro.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Getter
public class RegistroProp {

    @Value("${registro.base}")
    private String base;

    @Value("${registro.expireDate}")
    private int expireDate;

    @Value("${registro.subject}")
    private String subject;

    @Value("${nodeAPI}")
    private String nodeAPI;

    @Value("${pythonAPI}")
    private String pythonAPI;

    @Value("${registro.apikey}")
    private String apikey;

    @Value("${registro.vote.month.start}")
    private int voteStartDate;

    @Value("${registro.vote.month.end}")
    private int voteEndDate;

    @Value("${registro.language.default}")
    private String defaultLang;
}
