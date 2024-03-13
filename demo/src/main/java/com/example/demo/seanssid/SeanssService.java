package com.example.demo.seanssid;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeanssService {
    private final SeanssRepository seanssRepository;

    public SeanssService(SeanssRepository seanssRepository) {
        this.seanssRepository = seanssRepository;
    }

    public List<Seanss> getSeansid() {
        return seanssRepository.findAll();
    }

    public void addNewSeanss(Seanss seanss) {
        Optional<Seanss> seanssOptional = seanssRepository.findSeanssById(seanss.getId());
        if(seanssOptional.isPresent()){
            throw new IllegalStateException("Seanss olemas");
        }
        seanssRepository.save(seanss);
    }
}
