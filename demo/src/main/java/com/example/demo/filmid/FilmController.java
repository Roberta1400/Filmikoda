package com.example.demo.filmid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        if (vanusepiirang != null || žanr != null || keel != null) {
            return filmService.findByVanusepiirangAndŽanrAndKeel(vanusepiirang, žanr, keel);
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

    @GetMapping("/{filmiId}")
    public Optional<Film> getFilmbyID(@PathVariable Long filmiId) {
        return filmService.getFilmByID(filmiId);
    }
}