package org.example.service;

import org.example.entity.Songs;
import org.example.mapper.SongsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongsService {
    private final SongsMapper songsMapper;
    public SongsService(SongsMapper songsMapper){
        this.songsMapper = songsMapper;
    }
    public List<Songs> findByKeyword(String keyword){
        return songsMapper.findByKeyword(keyword);
    }
    public List<Songs> initSongs(){
        return songsMapper.initSongs();
    }



}
