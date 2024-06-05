package it.pi.registro.registro.configuration;

import it.pi.registro.registro.mapper.UserMapper;
import it.pi.registro.registro.mapper.UserMapperImpl;
import it.pi.registro.registro.mapper.VoteMapper;
import it.pi.registro.registro.mapper.VoteMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

    @Bean
    public VoteMapper voteMapper() {
        return new VoteMapperImpl();
    }
}
