package com.example.demo.filmid;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> getFilmid() {
        return filmRepository.findAll();
    }

    public void addNewFilm(Film film) {
        Optional<Film> filmOptional = filmRepository.findFilmById(film.getId());
        if(filmOptional.isPresent()){
            throw new IllegalStateException("Email võetud");
        }
        filmRepository.save(film);
    }

    public void deleteFilm(Long id) {
        boolean exists = filmRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Filmi ID "+id+" ei eksisteeri");
        }
        filmRepository.deleteById(id);
    }

    public List<Film> getFilmidByVanusepiirang(int vanusepiirang) {
        return filmRepository.findByVanusepiirang(vanusepiirang);
    }

    public List<Film> getFilmidByŽanr(String žanr) {
        return filmRepository.findByŽanr(žanr);
    }

    public List<Film> getFilmidByKeel(String keel) {
        return filmRepository.findByKeel(keel);
    }
}
