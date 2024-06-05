package it.pi.registro.registro.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Getter
@PropertySource("classpath:api.properties")
public class ApiProp {

    @Value("${api.url.whitelist}")
    private String[] whiteList;

    @Value("${api.url.blacklist}")
    private String[] blackList;

    @Value("${registro.apikey}")
    private String apikey;

    @Value("${registro.vote.month.start}")
    private int voteStartDate;

    @Value("${registro.vote.month.end}")
    private int voteEndDate;

    @Value("${registro.language.default}")
    private String defaultLang;
}
