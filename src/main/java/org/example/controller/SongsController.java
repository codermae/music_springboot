package org.example.controller;


import org.example.entity.Songs;
import org.example.entity.resultSongDTO;
import org.example.service.SongsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongsController {
    private final SongsService songsService;
    public SongsController(SongsService songsService){
        this.songsService = songsService;
    }
    @GetMapping("/{keyword}")
    public List<resultSongDTO> findByKeyword(@PathVariable String keyword){
        return songsService.findByKeyword(keyword);
    }
    @GetMapping("/ran")
    public List<Songs> initSongs(){
        return songsService.initSongs();
    }

    @GetMapping("/all")
    public List<Songs> allSongs(){
        return songsService.allSongs();
    }

    @PostMapping
    public int createSong(@RequestBody Songs song)
    {
        return songsService.insert(song);
    }

    @DeleteMapping("/{id}")
    public int deleteSong(@PathVariable int id)
    {
        return songsService.deleteById(id);
    }

    @PutMapping("/{id}")
    public int updateSong(@PathVariable int id,@RequestBody Songs song){
        song.setId(id);
        return songsService.update(song);
    }








}
