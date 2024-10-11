package org.example.service;

import org.example.entity.Songs;
import org.example.entity.resultSongDTO;
import org.example.mapper.SongsMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SongsService {
    private final SongsMapper songsMapper;
    public SongsService(SongsMapper songsMapper){
        this.songsMapper = songsMapper;
    }
    public List<resultSongDTO> findByKeyword(String keyword){
        return songsMapper.findByKeyword(keyword);
    }
    public List<Songs> initSongs(){
        return songsMapper.initSongs();
    }

    public List<Songs> allSongs(){ return songsMapper.allSongs();}

    public int countSongs(){ return songsMapper.countSongs();}

    public List<Map<String, Object>> genreSongs(){
        return songsMapper.genreSong();
    }

    public int insert(Songs songs){
        return songsMapper.insert(songs);
    }

    public int deleteById(int id){
        return songsMapper.deleteById(id);
    }

    public int update(Songs songs){ return songsMapper.update(songs);}


}
