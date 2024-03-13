package com.example.demo.istekohad;

import com.example.demo.filmid.Film;
import com.example.demo.istekohad.Istekohad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/istekohad")
public class IstekohadController {
    private final IstekohadService istekohadService;

    @Autowired
    public IstekohadController(IstekohadService istekohadService) {
        this.istekohadService = istekohadService;
    }

    @GetMapping
    public List<Istekohad> getIstekohad() {
        return istekohadService.getIstekohad();
    }

    @PostMapping
    public void addNewIstekoht(@RequestBody Istekohad istekoht){
        istekohadService.addNewIstekoht(istekoht);
    }
}
