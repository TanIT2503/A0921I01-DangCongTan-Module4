package com.codegym.service.impl;

import com.codegym.entity.Song;
import com.codegym.repository.SongRepository;
import com.codegym.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private SongRepository songRepository;
    @Autowired
    public SongServiceImpl(SongRepository songRepository){
        this.songRepository = songRepository;
    }
    @Override
    public void create(Song song) {
        songRepository.create(song);
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song update(int id, Song song) {
        songRepository.update(song);
        return null;
    }

    @Override
    public void listen(Song song) {

    }

    @Override
    public void delete(int id) {
        songRepository.delete(id);
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id);
    }
}
