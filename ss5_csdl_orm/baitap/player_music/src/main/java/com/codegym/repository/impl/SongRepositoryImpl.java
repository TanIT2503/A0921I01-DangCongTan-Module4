package com.codegym.repository.impl;

import com.codegym.entity.Song;
import com.codegym.repository.SongRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class SongRepositoryImpl implements SongRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void create(Song song) {
        entityManager.persist(song);
    }

    @Override
    public List<Song> findAll() {
        return entityManager.createQuery("select s from Song s").getResultList();
    }

    @Override
    public void update(Song song) {
        entityManager.merge(song);
    }

    @Override
    public void listen(Song song) {

    }

    @Override
    public void delete(int id) {
        Song song = findById(id);
        entityManager.remove(song);
    }

    @Override
    public Song findById(int id) {
        return entityManager.find(Song.class, id);
    }

}
