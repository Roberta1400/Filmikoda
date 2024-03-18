package com.example.demo.filmid;

import com.example.demo.kasutaja.Kasutaja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query("SELECT s FROM Film s WHERE s.id = ?1")
    Optional<Film> findFilmById(Long id);

    @Query("SELECT s FROM Film s WHERE s.vanusepiirang = ?1")
    List<Film> findByVanusepiirang(int vanusepiirang);

    @Query("SELECT s FROM Film s WHERE s.žanr = ?1")
    List<Film> findByŽanr(String žanr);

    @Query("SELECT s FROM Film s WHERE s.keel = ?1")
    List<Film> findByKeel(String keel);
}
