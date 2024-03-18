package com.example.demo.filmid;

import com.example.demo.filmid.FilmService;
import com.example.demo.kasutaja.Kasutaja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/filmid")
@CrossOrigin
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public List<Film> getFilmid(@RequestParam(required = false) String vanusepiirang,
                                @RequestParam(required = false) String žanr,
                                @RequestParam(required = false) String keel)//chatgpt näitas kuidas lisada parameetreid
   {
        if (vanusepiirang != null) {
            return filmService.getFilmidByVanusepiirang(Integer.parseInt(vanusepiirang));
        } else if (žanr != null) {
            return filmService.getFilmidByŽanr(žanr);
        } else if (keel != null) {
            return filmService.getFilmidByKeel(keel);
        } else {
            return filmService.getFilmid();
        }
    }

    @PostMapping
    public void addNewFilm(@RequestBody Film film){
        filmService.addNewFilm(film);
    }


    @DeleteMapping(path = "{filmId}")
    public void deleteKasutaja(@PathVariable("filmId") Long filmId){
        filmService.deleteFilm(filmId);
    }
}