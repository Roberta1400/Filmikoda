package com.example.demo.istekohad;

import com.example.demo.saalid.Saal;
import com.example.demo.saalid.SaalRepository;
import com.example.demo.saalid.SaalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class IstekohadConfig {
    @Bean
    public IstekohadService istekohadService(IstekohadRepository istekohadRepository) {
        return new IstekohadService(istekohadRepository);
    }

    @Bean
    CommandLineRunner istekohadCommandLineRunner(IstekohadRepository repository){
        return args -> {

            repository.saveAll(List.of());
        };
    }
}
