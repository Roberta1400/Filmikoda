package com.example.demo.seanssid;

import com.example.demo.kasutaja.Kasutaja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SeanssRepository extends JpaRepository<Seanss, Long> {

    @Query("SELECT s FROM Seanss s WHERE s.id = ?1")
    Optional<Seanss> findSeanssById(Long id);
}
