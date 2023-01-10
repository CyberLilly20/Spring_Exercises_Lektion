package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.lexicon.dao.AccountDao;
import se.lexicon.dao.impl.AccountDaoImpl;

@Configuration
@ComponentScan(basePackages = "se.lexicon")
public class AppConfig {

    @Bean
    public AccountDao accountDao(){
        return new AccountDaoImpl();
    } //example 2 it is better to use this
}
