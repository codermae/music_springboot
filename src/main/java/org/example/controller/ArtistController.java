package org.example.controller;

import org.example.entity.Artists;
import org.example.service.ArtistService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public int insert(@RequestBody Artists artist){
        return artistService.insert(artist);
    }

    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable int id){
        return artistService.deleteById(id);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable int id,@RequestBody Artists artist){
        artist.setId(id);
        return artistService.update(artist);
    }

}
