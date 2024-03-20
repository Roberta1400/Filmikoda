package com.example.demo.istekohad;

import com.example.demo.filmid.Film;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IstekohadService {

    private final IstekohadRepository istekohadRepository;

    public IstekohadService(IstekohadRepository istekohadRepository) {
        this.istekohadRepository = istekohadRepository;
    }

    public List<Istekohad> getIstekohad() {
        return istekohadRepository.findAll();
    }

    public void addNewIstekoht(Istekohad istekoht) {
        Optional<Istekohad> istekohtOptional = istekohadRepository.findIstekohtById(istekoht.getId());
        if(istekohtOptional.isPresent()){
            throw new IllegalStateException("Istekoht olemas");
        }
        istekohadRepository.save(istekoht);
    }

    public List<Istekohad> getIstekohadBySaalID(Long saalId) {
        return istekohadRepository.getIstekohadBySaalID(saalId);
    }
}
