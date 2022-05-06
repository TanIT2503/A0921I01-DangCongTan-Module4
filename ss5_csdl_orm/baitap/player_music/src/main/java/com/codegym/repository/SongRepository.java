package com.codegym.repository;

import com.codegym.entity.Song;

import java.util.List;

public interface SongRepository {
    public void create(Song song);
    public List<Song> findAll();
    public void update(Song song);
    public void listen(Song song);
    public void delete(int id);
    Song findById(int id);
}
