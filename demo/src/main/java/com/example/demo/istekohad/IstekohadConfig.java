package com.example.demo.istekohad;

import com.example.demo.saalid.Saal;
import com.example.demo.saalid.SaalRepository;
import com.example.demo.saalid.SaalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class IstekohadConfig {
    @Bean
    public IstekohadService istekohadService(IstekohadRepository istekohadRepository) {
        return new IstekohadService(istekohadRepository);
    }

    @Bean
    @Order(5)
    CommandLineRunner istekohadCommandLineRunner(IstekohadRepository repository, SaalRepository saalRepository) {
        return args -> {
            Saal kosmos = saalRepository.findById(1L).orElseThrow(() -> new RuntimeException("Saal 'Kosmos' ei leitud"));
            Saal imax = saalRepository.findById(2L).orElseThrow(() -> new RuntimeException("Saal 'IMAX' ei leitud"));

            for (int reaNr = 1; reaNr <= 4; reaNr++) {
                for (int kohaId = 1; kohaId <= 8; kohaId++) {
                    boolean kasVõetud = (reaNr == 2 && (kohaId == 2 || kohaId == 6));
                    Istekohad istekoht = new Istekohad(null, kohaId, reaNr, kasVõetud, kosmos);
                    repository.save(istekoht);
                }
            }

            for (int reaNr = 1; reaNr <= 4; reaNr++) {
                for (int kohaId = 9; kohaId <= 16; kohaId++) {
                    boolean kasVõetud = (reaNr == 3 && (kohaId == 10 || kohaId == 13));
                    Istekohad istekoht = new Istekohad(null, kohaId, reaNr, kasVõetud, imax);
                    repository.save(istekoht);
                }
            }
        };
    }
}
