package com.andres.app_list.model;

import jakarta.persistence.*;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "artista")
    private String artista;

    @Column(name = "album")
    private String album;

    @Column(name = "anno")
    private Integer anno;

    @Column(name = "genero")
    private String genero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playlist_nombre", nullable = false)
    private Playlist playlist;

    public Song() {}

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getArtista() { return artista; }
    public void setArtista(String artista) { this.artista = artista; }

    public String getAlbum() { return album; }
    public void setAlbum(String album) { this.album = album; }

    public Integer getAnno() { return anno; }
    public void setAnno(Integer anno) { this.anno = anno; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public Playlist getPlaylist() { return playlist; }
    public void setPlaylist(Playlist playlist) { this.playlist = playlist; }
}

