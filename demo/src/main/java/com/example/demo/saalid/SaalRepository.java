package com.example.demo.saalid;

import com.example.demo.filmid.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaalRepository extends JpaRepository<Saal, Long> {
    @Query("SELECT s FROM Saal s WHERE s.id = ?1")
    List<Saal> findAll();
}
