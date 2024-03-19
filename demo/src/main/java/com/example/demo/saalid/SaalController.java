package com.example.demo.saalid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/saalid")
@CrossOrigin
public class SaalController {

    private final SaalService saalService;

    @Autowired
    public SaalController(SaalService saalService) {
        this.saalService = saalService;
    }

    @GetMapping
    public List<Saal> getSaalid() {
        return saalService.getSaalid();
    }

    @GetMapping("/{saalId}")
    public Optional<Saal> getSaalbyID(@PathVariable Long saalId) {
        return saalService.getSaalByID(saalId);
    }

}
