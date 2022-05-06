package com.codegym.service;

import com.codegym.entity.Song;

import java.util.List;

public interface SongService {
    public void create(Song song);
    public List<Song> findAll();
    public Song update(int id, Song song);
    public void listen(Song song);
    public void delete(int id);
    Song findById(int id);
}
