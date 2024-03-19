package com.example.demo.seanssid;

import com.example.demo.filmid.Film;
import com.example.demo.filmid.FilmRepository;
import com.example.demo.saalid.Saal;
import com.example.demo.saalid.SaalRepository;
import com.example.demo.saalid.SaalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class SeanssConfig {

    @Bean
    public SeanssService seanssService(SeanssRepository seanssRepository) {
        return new SeanssService(seanssRepository);
    }
    @Bean
    CommandLineRunner seanssidCommandLineRunner(SeanssRepository repository, FilmRepository filmRepository, SaalRepository saalRepository) {
        return args -> {
            Film interstellar = filmRepository.findById(1L).orElse(null);
            Film lotte = filmRepository.findById(2L).orElse(null);
            Saal kosmos = saalRepository.findById(1L).orElse(null);
            Saal imax = saalRepository.findById(2L).orElse(null);

            LocalDateTime algusaeg1 = LocalDateTime.of(2024, 4, 1, 14, 30);
            LocalDateTime algusaeg2 = LocalDateTime.of(2024, 4, 2, 16, 0);
            LocalDateTime algusaeg3 = LocalDateTime.of(2024, 4, 3, 18, 30);
            LocalDateTime algusaeg4 = LocalDateTime.of(2024, 4, 4, 20, 0);
            LocalDateTime algusaeg5 = LocalDateTime.of(2024, 4, 5, 14, 0);
            LocalDateTime algusaeg6 = LocalDateTime.of(2024, 4, 6, 16, 30);
            LocalDateTime algusaeg7 = LocalDateTime.of(2024, 4, 7, 18, 0);
            LocalDateTime algusaeg8 = LocalDateTime.of(2024, 4, 8, 20, 30);
            LocalDateTime algusaeg9 = LocalDateTime.of(2024, 4, 9, 14, 30);
            LocalDateTime algusaeg10 = LocalDateTime.of(2024, 4, 10, 16, 0);

            repository.saveAll(List.of(
                    new Seanss(algusaeg1, interstellar, kosmos),
                    new Seanss(algusaeg2, interstellar, imax),
                    new Seanss(algusaeg3, lotte, kosmos),
                    new Seanss(algusaeg4, lotte, imax),
                    new Seanss(algusaeg5, interstellar, kosmos),
                    new Seanss(algusaeg6, interstellar, imax),
                    new Seanss(algusaeg7, lotte, kosmos),
                    new Seanss(algusaeg8, lotte, imax),
                    new Seanss(algusaeg9, interstellar, kosmos),
                    new Seanss(algusaeg10, interstellar, imax)
            ));
        };
    }
}
