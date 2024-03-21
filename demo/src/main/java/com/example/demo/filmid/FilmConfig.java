package com.example.demo.filmid;

import com.example.demo.filmid.FilmService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class FilmConfig {

    @Bean
    public FilmService filmService(FilmRepository filmRepository) {
        return new FilmService(filmRepository);
    }

    @Bean
    @Order(1)
    CommandLineRunner filmCommandLineRunner(FilmRepository repository){
        return args -> {
            Film lotte = new Film(1L,"Lotte", "animatsioon", "0", "eesti", "");
            Film interstellar = new Film("Interstellar", "scifi", "14", "inglise","demo/src/pildid/interstellar.jpeg");
            Film film1 = new Film("Pulp Fiction", "drama", "18", "inglise", "");
            Film film2 = new Film("The Notebook", "romcom", "12", "inglise", "");
            Film film3 = new Film("The Shining", "horror", "16", "inglise", "");
            Film film4 = new Film("The Godfather", "drama", "18", "inglise", "");
            Film film5 = new Film("Titanic", "romcom", "12", "inglise", "");
            Film film6 = new Film("Psycho", "horror", "16", "inglise", "");
            Film film7 = new Film("Forrest Gump", "drama", "12", "inglise", "");
            Film film8 = new Film("Bridget Jones's Diary", "romcom", "12", "inglise", "");
            Film film9 = new Film("The Exorcist", "horror", "18", "inglise", "");
            Film film10 = new Film("The Shawshank Redemption", "drama", "16", "inglise", "");
            Film film11 = new Film("10 Things I Hate About You", "romcom", "12", "inglise", "");
            Film film12 = new Film("A Quiet Place", "horror", "16", "inglise", "");
            Film film13 = new Film("The Green Mile", "drama", "16", "inglise", "");
            Film film14 = new Film("When Harry Met Sally", "romcom", "12", "inglise", "");
            Film film15 = new Film("Scream", "horror", "18", "inglise", "");
            Film film16 = new Film("Fight Club", "drama", "18", "inglise", "");
            Film film17 = new Film("Notting Hill", "romcom", "12", "inglise", "");
            repository.saveAll(List.of(lotte, interstellar, film1, film2, film3, film4, film5, film6, film7, film8, film9, film10,
                    film11, film12, film13,film14, film15, film16, film17));
        };
    }
}
