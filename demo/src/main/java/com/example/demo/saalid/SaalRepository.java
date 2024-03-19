package com.example.demo.saalid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SaalRepository extends JpaRepository<Saal, Long> {
    @Query("SELECT s FROM Saal s WHERE s.id = ?1")
    List<Saal> findAll();

    @Query("SELECT s FROM Saal s WHERE s.id = ?1")
    Optional<Saal> findById(Long saalId);
}
