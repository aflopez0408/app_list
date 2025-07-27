package com.andres.app_list.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.andres.app_list.model.Playlist;
import com.andres.app_list.model.Song;
import com.andres.app_list.dto.PlaylistDTO;
import com.andres.app_list.dto.SongDTO;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaylistMapper {


    @Mapping(target = "canciones", source = "canciones")
    PlaylistDTO toDto(Playlist entity);

    @Mapping(target = "canciones", source = "canciones")
    Playlist toEntity(PlaylistDTO dto);


    SongDTO toDto(Song entity);
    Song toEntity(SongDTO dto);


    List<SongDTO> toDtoList(List<Song> songs);
    List<Song> toEntityList(List<SongDTO> dtos);
}

