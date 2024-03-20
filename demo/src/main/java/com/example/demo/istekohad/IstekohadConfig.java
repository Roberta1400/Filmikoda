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
    CommandLineRunner istekohadCommandLineRunner(IstekohadRepository repository, SaalRepository saalRepository){
        return args -> {
            Saal kosmos = saalRepository.findById(1L).orElseThrow(() -> new RuntimeException("Saal 'Kosmos' ei leitud"));
            Saal imax = saalRepository.findById(2L).orElseThrow(() -> new RuntimeException("Saal 'IMAX' ei leitud"));

            Istekohad üks = new Istekohad(1L,1,1,false, kosmos);
            Istekohad kaks = new Istekohad(2L,2,1,false, kosmos);
            Istekohad kolm = new Istekohad(3L,3,1,false, kosmos);
            Istekohad neli = new Istekohad(4L,4,1,false, kosmos);
            Istekohad viis= new Istekohad(5L,5,1,true, kosmos);
            Istekohad kuus = new Istekohad(6L,6,2,false, kosmos);
            Istekohad seitse = new Istekohad(7L,7,2,true, kosmos);
            Istekohad kaheksa = new Istekohad(8L,8,2,false, imax);
            Istekohad üheksa = new Istekohad(9L,9,2,false, imax);
            Istekohad kümme = new Istekohad(10L,10,2,false, imax);
            repository.saveAll(List.of(üks, kaks, kolm, neli, viis, kuus, seitse, kaheksa, üheksa, kümme));
        };
    }
}
