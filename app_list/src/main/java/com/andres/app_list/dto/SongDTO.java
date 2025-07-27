package com.andres.app_list.dto;

public class SongDTO {
    private Long id;
    private String titulo;
    private String artista;
    private String album;
    private Integer anno;
    private String genero;

    public SongDTO() {}

    public SongDTO(Long id, String titulo, String artista, String album, Integer anno, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.anno = anno;
        this.genero = genero;
    }

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
}

