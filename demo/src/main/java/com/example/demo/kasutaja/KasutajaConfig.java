package com.example.demo.kasutaja;

import com.example.demo.filmid.Film;
import com.example.demo.filmid.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class KasutajaConfig {
    @Bean
    @Order(2)
    CommandLineRunner commandLineRunner(KasutajaRepository repository, FilmRepository filmRepository){
        return args -> {
            Film film1 = filmRepository.getReferenceById(1L);
            Film film2 = filmRepository.getReferenceById(3L);
            Film film3 = filmRepository.getReferenceById(6L);
            List<Film> filmid = List.of(film1,film2,film3);
            Kasutaja eva = new Kasutaja(1L, "eva", "ma.olen.eva@gmail.com", "kass123", filmid);
            Kasutaja aadam = new Kasutaja("aadam", "ma.olen.aadam@gmail.com", "kass1234", new ArrayList<>());
            repository.saveAll(List.of(eva, aadam));
        };
    }
}
