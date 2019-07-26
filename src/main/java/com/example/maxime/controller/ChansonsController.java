package com.example.maxime.controller;

import com.example.maxime.dto.ChansonDto;
import com.example.maxime.repository.ChansonsRepository;
import com.example.maxime.service.ChansonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/chanson")
public class ChansonsController {

    @Autowired
    ChansonsService chansonsService;

    @GetMapping
    public Collection<ChansonDto> getAllSongs() {
        return chansonsService.getAll();
    }

}
