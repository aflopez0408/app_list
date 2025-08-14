package com.andres.app_list.repository;

import com.andres.app_list.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {


    //Song findByTitulo (String Titulo);
    List<Song> findByTitulo(String titulo);
}
