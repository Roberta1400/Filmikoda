package com.example.demo.istekohad;

import com.example.demo.filmid.Film;
import com.example.demo.saalid.Saal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IstekohadRepository extends JpaRepository<Istekohad, Long> {

    @Query("SELECT s FROM Istekohad s WHERE s.id = ?1")
    Optional<Istekohad> findIstekohtById(Long id);
}
