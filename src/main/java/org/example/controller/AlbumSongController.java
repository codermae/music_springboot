package org.example.controller;

import org.example.entity.AlbumSongInfo;
import org.example.service.AlbumSongService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AlbumSongController {

    private final AlbumSongService albumSongService;
    public AlbumSongController(AlbumSongService albumSongService) {
        this.albumSongService = albumSongService;
    }
    @GetMapping("/album")
    public List<AlbumSongInfo> getAlbumSongInfo() {
        return albumSongService.getAlbumSongInfo();
    }
}
