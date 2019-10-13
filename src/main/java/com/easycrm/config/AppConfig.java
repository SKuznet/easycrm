package com.easycrm.config;

import com.easycrm.model.Crocodile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public Crocodile crocodile() {
        // logic
        return new Crocodile();
    }
}
