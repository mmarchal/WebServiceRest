package com.example.maxime.controller;

import com.example.maxime.dto.ActeursDto;
import com.example.maxime.service.ActeursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin("*")
@RestController
@RequestMapping("/acteurs")
public class ActeursController {

    @Autowired
    private ActeursService acteursService;

    @GetMapping
    public Collection<ActeursDto> getAllActeurs() {
        return acteursService.getActeurs();
    }

    @PostMapping
    public boolean synchroActeurs(){
        try {
            //this.acteursService.synchro();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @PostMapping(value = "/add")
    public boolean insertOneActeur(@RequestBody ActeursDto acteur) {
        try {
            this.acteursService.insertData(acteur);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
