package com.example.demo.seansid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SeanssRepository extends JpaRepository<Seanss, Long> {

    @Query("SELECT s FROM Seanss s WHERE s.id = ?1")
    Optional<Seanss> findSeanssById(Long id);
}
