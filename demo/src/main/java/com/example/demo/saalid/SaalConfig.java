package com.example.demo.saalid;

import com.example.demo.filmid.Film;
import com.example.demo.filmid.FilmRepository;
import com.example.demo.filmid.FilmService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class SaalConfig {

    @Bean
    public SaalService saalService(SaalRepository saalRepository) {
        return new SaalService(saalRepository);
    }

    @Bean
    @Order(3)
    CommandLineRunner saalCommandLineRunner(SaalRepository repository){
        return args -> {
            Saal kosmos = new Saal(1L,"Kosmos");
            Saal imax = new Saal(2L,"Imax");
            Saal unistus = new Saal(3L,"Unistus");
            Saal roosiaed = new Saal(4L,"Roosiaed");
            repository.saveAll(List.of(kosmos, imax, unistus, roosiaed));
        };
    }
}
