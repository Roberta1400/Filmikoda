package com.example.demo.istekohad;

import com.example.demo.filmid.Film;
import com.example.demo.istekohad.Istekohad;
import com.example.demo.saalid.Saal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/istekohad")
@CrossOrigin
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

    @GetMapping("/{saalId}")
    public List<Istekohad> getIstekohadbySaalID(@PathVariable Long saalId) {
        return istekohadService.getIstekohadBySaalID(saalId);
    }
}
