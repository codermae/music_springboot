package org.example.service;

import org.example.entity.Favorites;
import org.example.entity.FavoritsSongDTO;
import org.example.entity.Songs;
import org.example.mapper.FavoritesMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesService {
    private final FavoritesMapper favoritesMapper;
    public FavoritesService(FavoritesMapper favoritesMapper){
        this.favoritesMapper = favoritesMapper;
    }
    public List<FavoritsSongDTO> favoritesByUser_id(String user_id){
        return favoritesMapper.favoritesByUser_id(user_id);
    }
    public int insert(Favorites favorites){
        return favoritesMapper.insert(favorites);
    }
    public int delete(Favorites favorites){
        return favoritesMapper.delete(favorites);
    }
}
