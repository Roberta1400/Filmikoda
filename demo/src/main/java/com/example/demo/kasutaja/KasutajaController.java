package com.example.demo.kasutaja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/kasutaja")
public class KasutajaController {

    private final KasutajaService kasutajaService;

    @Autowired
    public KasutajaController(KasutajaService kasutajaService) {
        this.kasutajaService = kasutajaService;
    }

    @GetMapping
    public  List<Kasutaja> getKasutajad(){
        return kasutajaService.getKasutajad();
    }

    @PostMapping
    public void registerNewKasutaja(@RequestBody Kasutaja kasutaja){
        kasutajaService.addNewKasutaja(kasutaja);
    }

    @DeleteMapping(path = "{kasutajaId}")
    public void deleteKasutaja(@PathVariable("kasutajaId") Long kasutajaId){
        kasutajaService.deleteKasutaja(kasutajaId);
    }

}
