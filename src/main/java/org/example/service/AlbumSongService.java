package org.example.service;

import org.example.entity.AlbumSongInfo;
import org.example.mapper.AlbumSongMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlbumSongService {

    private final AlbumSongMapper albumSongMapper;
    public AlbumSongService(AlbumSongMapper albumSongMapper) {
        this.albumSongMapper = albumSongMapper;
    }

    public List<AlbumSongInfo> getAlbumSongInfo() {
        return albumSongMapper.getAlbumSongInfo();
    }
}
