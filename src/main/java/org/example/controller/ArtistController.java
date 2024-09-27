package org.example.controller;

import org.example.entity.Artists;
import org.example.service.ArtistService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    private final ArtistService artistService;
    public ArtistController(ArtistService artistService){
        this.artistService = artistService;
    }

    @GetMapping
    public List<Artists> findAll(){
        return artistService.findAll();
    }

    @GetMapping("/{id}")
    public List<Artists> findById(@PathVariable int id){
        return artistService.findById(id);
    }

}
