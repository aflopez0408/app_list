package com.andres.app_list.mapper;

import com.andres.app_list.dto.PlaylistDTO;
import com.andres.app_list.dto.SongDTO;
import com.andres.app_list.model.Playlist;
import com.andres.app_list.model.Song;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-27T09:23:52-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class PlaylistMapperImpl implements PlaylistMapper {

    @Override
    public PlaylistDTO toDto(Playlist entity) {
        if ( entity == null ) {
            return null;
        }

        PlaylistDTO playlistDTO = new PlaylistDTO();

        playlistDTO.setCanciones( songSetToSongDTOList( entity.getCanciones() ) );
        playlistDTO.setNombre( entity.getNombre() );
        playlistDTO.setDescripcion( entity.getDescripcion() );

        return playlistDTO;
    }

    @Override
    public Playlist toEntity(PlaylistDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Playlist playlist = new Playlist();

        playlist.setCanciones( songDTOListToSongSet( dto.getCanciones() ) );
        playlist.setNombre( dto.getNombre() );
        playlist.setDescripcion( dto.getDescripcion() );

        return playlist;
    }

    @Override
    public SongDTO toDto(Song entity) {
        if ( entity == null ) {
            return null;
        }

        SongDTO songDTO = new SongDTO();

        songDTO.setId( entity.getId() );
        songDTO.setTitulo( entity.getTitulo() );
        songDTO.setArtista( entity.getArtista() );
        songDTO.setAlbum( entity.getAlbum() );
        songDTO.setAnno( entity.getAnno() );
        songDTO.setGenero( entity.getGenero() );

        return songDTO;
    }

    @Override
    public Song toEntity(SongDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Song song = new Song();

        song.setId( dto.getId() );
        song.setTitulo( dto.getTitulo() );
        song.setArtista( dto.getArtista() );
        song.setAlbum( dto.getAlbum() );
        song.setAnno( dto.getAnno() );
        song.setGenero( dto.getGenero() );

        return song;
    }

    @Override
    public List<SongDTO> toDtoList(List<Song> songs) {
        if ( songs == null ) {
            return null;
        }

        List<SongDTO> list = new ArrayList<SongDTO>( songs.size() );
        for ( Song song : songs ) {
            list.add( toDto( song ) );
        }

        return list;
    }

    @Override
    public List<Song> toEntityList(List<SongDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Song> list = new ArrayList<Song>( dtos.size() );
        for ( SongDTO songDTO : dtos ) {
            list.add( toEntity( songDTO ) );
        }

        return list;
    }

    protected List<SongDTO> songSetToSongDTOList(Set<Song> set) {
        if ( set == null ) {
            return null;
        }

        List<SongDTO> list = new ArrayList<SongDTO>( set.size() );
        for ( Song song : set ) {
            list.add( toDto( song ) );
        }

        return list;
    }

    protected Set<Song> songDTOListToSongSet(List<SongDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<Song> set = new LinkedHashSet<Song>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( SongDTO songDTO : list ) {
            set.add( toEntity( songDTO ) );
        }

        return set;
    }
}
