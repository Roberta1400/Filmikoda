package com.example.demo.saalid;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaalService {
    private final SaalRepository saalRepository;

    public SaalService(SaalRepository saalRepository) {
        this.saalRepository = saalRepository;
    }

    public List<Saal> getSaalid() {
        return saalRepository.findAll();
    }

    public Optional<Saal> getSaalByID(Long saalId) {
        return saalRepository.findById(saalId);
    }
}
