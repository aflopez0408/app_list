package com.andres.app_list.controller;

import com.andres.app_list.dto.PlaylistDTO;
import com.andres.app_list.service.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }


    @PostMapping
    public ResponseEntity<PlaylistDTO> createPlaylist(@RequestBody PlaylistDTO playlistDTO) {
        PlaylistDTO created = playlistService.create(playlistDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }


    @GetMapping
    public ResponseEntity<List<PlaylistDTO>> getAllPlaylists() {
        List<PlaylistDTO> all = playlistService.findAll();
        return ResponseEntity.ok(all);
    }


    @GetMapping("/{nombre}")
    public ResponseEntity<PlaylistDTO> getPlaylistByName(@PathVariable String nombre) {
        PlaylistDTO dto = playlistService.findByName(nombre);
        return ResponseEntity.ok(dto);
    }


    @DeleteMapping("/{nombre}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable String nombre) {
        playlistService.delete(nombre);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/por-titulo-cancion")
    public ResponseEntity<List<String>> obtenerPlaylistsPorTituloCancion(@RequestParam String titulo) {
        List<String> nombres = playlistService.obtenerPlaylistsPorTituloCancion(titulo);
        return ResponseEntity.ok(nombres);
    }
}

