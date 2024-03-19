package com.example.demo.filmid;

import com.example.demo.kasutaja.Kasutaja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query("SELECT s FROM Film s WHERE s.id = ?1")
    Optional<Film> findFilmById(Long id);

    @Query("SELECT s FROM Film s WHERE " +
            "(?1 IS NULL OR s.vanusepiirang = ?1) AND " +
            "(?2 IS NULL OR s.žanr = ?2) AND " +
            "(?3 IS NULL OR s.keel = ?3)")
    List<Film> findByVanusepiirangAndŽanrAndKeel(String vanusepiirang, String žanr, String keel);
}
