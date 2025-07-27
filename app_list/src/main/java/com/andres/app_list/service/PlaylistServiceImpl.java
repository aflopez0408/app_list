package com.andres.app_list.service;

import com.andres.app_list.dto.PlaylistDTO;
import com.andres.app_list.dto.SongDTO;
import com.andres.app_list.exception.ResourceNotFoundException;
import com.andres.app_list.model.Playlist;
import com.andres.app_list.model.Song;
import com.andres.app_list.repository.PlaylistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository repo;

    public PlaylistServiceImpl(PlaylistRepository repo) {
        this.repo = repo;
    }

    @Override
    public PlaylistDTO create(PlaylistDTO dto) {
        // Mapear DTO → Entity
        Playlist entity = new Playlist();
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());

        if (dto.getCanciones() != null) {
            Set<Song> songs = dto.getCanciones().stream()
                    .map(songDto -> {
                        Song s = new Song();
                        s.setTitulo(songDto.getTitulo());
                        s.setArtista(songDto.getArtista());
                        s.setAlbum(songDto.getAlbum());
                        s.setAnno(songDto.getAnno());
                        s.setGenero(songDto.getGenero());
                        s.setPlaylist(entity);
                        return s;
                    })
                    .collect(Collectors.toSet());
            entity.setCanciones(songs);
        }

        // Guardar
        Playlist saved = repo.save(entity);

        // Mapear Entity → DTO
        PlaylistDTO out = new PlaylistDTO();
        out.setNombre(saved.getNombre());
        out.setDescripcion(saved.getDescripcion());
        if (saved.getCanciones() != null) {
            out.setCanciones(
                    saved.getCanciones().stream()
                            .map(song -> {
                                SongDTO sd = new SongDTO();
                                sd.setTitulo(song.getTitulo());
                                sd.setArtista(song.getArtista());
                                sd.setAlbum(song.getAlbum());
                                sd.setAnno(song.getAnno());
                                sd.setGenero(song.getGenero());
                                return sd;
                            })
                            .collect(Collectors.toList())
            );
        }
        return out;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlaylistDTO> findAll() {
        return repo.findAll().stream()
                .map(p -> {
                    PlaylistDTO dto = new PlaylistDTO();
                    dto.setNombre(p.getNombre());
                    dto.setDescripcion(p.getDescripcion());
                    if (p.getCanciones() != null) {
                        dto.setCanciones(
                                p.getCanciones().stream()
                                        .map(s -> {
                                            SongDTO sd = new SongDTO();
                                            sd.setTitulo(s.getTitulo());
                                            sd.setArtista(s.getArtista());
                                            sd.setAlbum(s.getAlbum());
                                            sd.setAnno(s.getAnno());
                                            sd.setGenero(s.getGenero());
                                            return sd;
                                        })
                                        .collect(Collectors.toList())
                        );
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public PlaylistDTO findByName(String nombre) {
        Playlist p = repo.findById(nombre)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist no encontrada: " + nombre));
        PlaylistDTO dto = new PlaylistDTO();
        dto.setNombre(p.getNombre());
        dto.setDescripcion(p.getDescripcion());
        if (p.getCanciones() != null) {
            dto.setCanciones(
                    p.getCanciones().stream()
                            .map(s -> {
                                SongDTO sd = new SongDTO();
                                sd.setTitulo(s.getTitulo());
                                sd.setArtista(s.getArtista());
                                sd.setAlbum(s.getAlbum());
                                sd.setAnno(s.getAnno());
                                sd.setGenero(s.getGenero());
                                return sd;
                            })
                            .collect(Collectors.toList())
            );
        }
        return dto;
    }

    @Override
    public void delete(String nombre) {
        Playlist p = repo.findById(nombre)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist no encontrada: " + nombre));
        repo.delete(p);
    }
}


