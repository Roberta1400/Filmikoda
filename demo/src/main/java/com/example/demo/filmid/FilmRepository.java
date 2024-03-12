package com.example.demo.filmid;

import com.example.demo.kasutaja.Kasutaja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query("SELECT s FROM Film s WHERE s.id = ?1")
    Optional<Film> findFilmById(Long id);
}
