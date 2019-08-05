package com.example.maxime.controller;

import com.example.maxime.dto.SeriesAnimesDto;
import com.example.maxime.service.SeriesAnimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/seriesanimes")
public class SeriesAnimesController {

    @Autowired
    SeriesAnimesService seriesAnimesService;

    @GetMapping()
    public Collection<SeriesAnimesDto> getSeriesAnimes() {
        return seriesAnimesService.getAllSeriesAnimes();
    }
}
