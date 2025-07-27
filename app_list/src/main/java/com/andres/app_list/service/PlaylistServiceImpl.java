package com.andres.app_list.service;

import com.andres.app_list.dto.PlaylistDTO;
import com.andres.app_list.exception.ResourceNotFoundException;
import com.andres.app_list.mapper.PlaylistMapper;
import com.andres.app_list.model.Playlist;
import com.andres.app_list.repository.PlaylistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final PlaylistMapper playlistMapper;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository,
                               PlaylistMapper playlistMapper) {
        this.playlistRepository = playlistRepository;
        this.playlistMapper = playlistMapper;
    }

    @Override
    public PlaylistDTO create(PlaylistDTO playlistDTO) {

        Playlist entity = playlistMapper.toEntity(playlistDTO);

        Playlist saved = playlistRepository.save(entity);

        return playlistMapper.toDto(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlaylistDTO> findAll() {
        return playlistRepository.findAll().stream()
                .map(playlistMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public PlaylistDTO findByName(String nombre) {
        Playlist playlist = playlistRepository.findById(nombre)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Playlist no encontrada: " + nombre));
        return playlistMapper.toDto(playlist);
    }

    @Override
    public void delete(String nombre) {
        Playlist playlist = playlistRepository.findById(nombre)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Playlist no encontrada: " + nombre));
        playlistRepository.delete(playlist);
    }
}

