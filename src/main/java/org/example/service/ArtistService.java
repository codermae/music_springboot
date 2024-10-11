package org.example.service;

import org.example.entity.Artists;
import org.example.mapper.ArtistMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    private final ArtistMapper artistMapper;
    public ArtistService(ArtistMapper artistMapper){
        this.artistMapper = artistMapper;
    }
    public List<Artists> findAll(){
        return artistMapper.findAll();
    }

    public int countArtist(){
        return artistMapper.countArtists();
    }
    public List<Artists> findById(int id){
        return artistMapper.findById(id);
    }

    public int deleteById(int id){
        return artistMapper.deleteById(id);
    }
    public int insert(Artists artist){
        return artistMapper.insert(artist);
    }
    public int update(Artists artist){
        return artistMapper.update(artist);
    }

}
