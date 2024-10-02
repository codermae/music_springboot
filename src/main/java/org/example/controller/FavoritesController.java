package org.example.controller;

import org.example.entity.Favorites;
import org.example.entity.Songs;
import org.example.service.FavoritesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fav")
public class FavoritesController {
    private final FavoritesService favoritesService;
    public FavoritesController(FavoritesService favoritesService)
    {
        this.favoritesService = favoritesService;
    }
    @GetMapping("/{user_id}")
    public List<Songs> favoritesByUser_id(@PathVariable String user_id){
        return favoritesService.favoritesByUser_id(user_id);
    }
    @PostMapping
    public int addFavorites(@RequestBody Favorites favorites){
        return favoritesService.insert(favorites);
    }
    @DeleteMapping
    public int delete(@RequestBody Favorites favorites){
        return favoritesService.delete(favorites);
    }

}
