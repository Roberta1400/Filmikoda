package com.example.demo.saalid;

import com.example.demo.filmid.Film;
import com.example.demo.filmid.FilmRepository;
import com.example.demo.filmid.FilmService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class SaalConfig {

    @Bean
    public SaalService saalService(SaalRepository saalRepository) {
        return new SaalService(saalRepository);
    }

    @Bean
    CommandLineRunner saalCommandLineRunner(SaalRepository repository){
        return args -> {
            Saal kosmos = new Saal(1L,"Kosmos");
            Saal imax = new Saal("Imax");
            repository.saveAll(List.of(kosmos, imax));
        };
    }
}
