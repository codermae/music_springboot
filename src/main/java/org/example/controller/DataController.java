package org.example.controller;

import org.example.entity.DailyLoginCount;
import org.example.service.ArtistService;
import org.example.service.SongsService;
import org.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class DataController {
    private final SongsService songsService;
    private final UserService userService;
    private final ArtistService artistService;

    public DataController(SongsService songsService,UserService userService,ArtistService artistService) {
        this.songsService = songsService;
        this.userService = userService;
        this.artistService = artistService;
    }


    //基本数据总数
    @GetMapping
    public ResponseEntity<Map<String,Integer>> getDataCounts(){
        Map<String,Integer> counts = new HashMap<>();
        counts.put("userCount", userService.countUser());
        counts.put("songCount",songsService.countSongs());
        counts.put("artistCount",artistService.countArtist());
        return ResponseEntity.ok(counts);
    }

    //歌曲类型-饼
    @GetMapping("/genre")
    public List<Map<String,Object>> getGenreSong(){
        return songsService.genreSongs();
    }

    //登录次数-折线
    @GetMapping("/e")
    public List<DailyLoginCount> getLoginCount(){
        return userService.loginCount();
    }

}
