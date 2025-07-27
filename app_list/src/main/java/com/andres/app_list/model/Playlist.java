package com.andres.app_list.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "playlists")
public class Playlist {

    @Id
    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @OneToMany(
            mappedBy = "playlist",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Set<Song> canciones;


    public Playlist() {}


    public Playlist(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Set<Song> getCanciones() { return canciones; }
    public void setCanciones(Set<Song> canciones) { this.canciones = canciones; }
}

