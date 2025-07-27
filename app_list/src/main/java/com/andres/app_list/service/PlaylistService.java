package com.andres.app_list.service;

import com.andres.app_list.dto.PlaylistDTO;
import java.util.List;

public interface PlaylistService {

    PlaylistDTO create(PlaylistDTO playlistDTO);

    List<PlaylistDTO> findAll();

    PlaylistDTO findByName(String nombre);

    void delete(String nombre);
}

