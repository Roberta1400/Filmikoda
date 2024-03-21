package com.example.demo.kasutaja;

import com.example.demo.filmid.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KasutajaService {

    private final KasutajaRepository kasutajaRepository;

    @Autowired
    public KasutajaService(KasutajaRepository kasutajaRepository) {
        this.kasutajaRepository = kasutajaRepository;
    }


    public List<Kasutaja> getKasutajad(){
        return kasutajaRepository.findAll();
    }

    public void addNewKasutaja(Kasutaja kasutaja) {
        Optional<Kasutaja> kasutajaOptional = kasutajaRepository.findKasutajaByEmail(kasutaja.getEmail());
        if(kasutajaOptional.isPresent()){
            throw new IllegalStateException("Email võetud");
        }
        kasutajaRepository.save(kasutaja);
    }

    public void deleteKasutaja(Long kasutajaId) {
        boolean exists = kasutajaRepository.existsById(kasutajaId);
        if(!exists){
            throw new IllegalStateException("Kasutaja ID "+kasutajaId+" ei eksisteeri");
        }
        kasutajaRepository.deleteById(kasutajaId);
    }

    public List<Film> getKasutajaVaadatudFilmid(Long kasutajaId) {
        Kasutaja kasutaja = kasutajaRepository.findById(kasutajaId).orElse(null);
        if (kasutaja != null) {
            return kasutaja.getVaadatudFilmid();
        } else {
            return null;
        }
    }
}
