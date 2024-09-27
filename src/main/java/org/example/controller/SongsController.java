package org.example.controller;


import org.example.entity.Songs;
import org.example.service.SongsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongsController {
    private final SongsService songsService;
    public SongsController(SongsService songsService){
        this.songsService = songsService;
    }
    @GetMapping("/{keyword}")
    public List<Songs> findByKeyword(@PathVariable String keyword){
        return songsService.findByKeyword(keyword);
    }
    @GetMapping
    public List<Songs> initSongs(){
        return songsService.initSongs();
    }



}
