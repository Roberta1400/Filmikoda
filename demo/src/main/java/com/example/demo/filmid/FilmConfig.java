package com.example.demo.filmid;

import com.example.demo.filmid.FilmService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FilmConfig {

    @Bean
    public FilmService filmService(FilmRepository filmRepository) {
        return new FilmService(filmRepository);
    }

    @Bean
    CommandLineRunner filmCommandLineRunner(FilmRepository repository){
        return args -> {
            Film lotte = new Film(1L,"Lotte", "animatsioon", "0", "eesti", "");
            Film interstellar = new Film("Interstellar", "scifi", "14", "inglise","/Users/robertasolom/Desktop/CGI-Suvepraktika_Ylesanne/demo/src/pildid/interstellar.jpeg");
            repository.saveAll(List.of(lotte, interstellar));
        };
    }
}
