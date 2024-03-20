package com.example.demo.seansid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/seansid")
@CrossOrigin
public class SeanssController {
    private final SeanssService seanssService;

    @Autowired
    public SeanssController(SeanssService seanssService) {
        this.seanssService = seanssService;
    }

    @GetMapping
    public List<Seanss> getSeansid() {
        return seanssService.getSeansid();
    }

    @PostMapping
    public void addNewSeanss(@RequestBody Seanss seanss){
        seanssService.addNewSeanss(seanss);
    }
}
