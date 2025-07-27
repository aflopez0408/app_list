package com.andres.app_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.andres.app_list.model.Playlist;


public interface PlaylistRepository extends JpaRepository<Playlist, String> {
}

