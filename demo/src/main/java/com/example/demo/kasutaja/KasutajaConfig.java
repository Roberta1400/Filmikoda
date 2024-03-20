package com.example.demo.kasutaja;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class KasutajaConfig {
    @Bean
    @Order(1)
    CommandLineRunner commandLineRunner(KasutajaRepository repository){
        return args -> {
            Kasutaja eva = new Kasutaja(1L, "eva", "ma.olen.eva@gmail.com", "kass123");
            Kasutaja aadam = new Kasutaja("aadam", "ma.olen.aadam@gmail.com", "kass1234");
            repository.saveAll(List.of(eva, aadam));
        };
    }
}
