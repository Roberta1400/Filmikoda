package com.example.demo.kasutaja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KasutajaRepository extends JpaRepository<Kasutaja, Long> {

    @Query("SELECT s FROM Kasutaja s WHERE s.email = ?1")
    Optional<Kasutaja> findKasutajaByEmail(String email);
}
