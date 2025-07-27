package com.andres.app_list.controller;

import com.andres.app_list.dto.PlaylistDTO;
import com.andres.app_list.service.PlaylistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WithMockUser(username = "admin", roles = {"USUARIO", "ADMIN"})
@WebMvcTest(PlaylistController.class)
public class PlaylistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PlaylistService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void create_return201() throws Exception {

        PlaylistDTO dto = new PlaylistDTO();
        dto.setNombre("lista1");
        dto.setDescripcion("DescripcionLista1");
        dto.setCanciones(new ArrayList<>());


        PlaylistDTO created = new PlaylistDTO();
        created.setNombre("Mi lista");
        created.setDescripcion("Descripción");
        created.setCanciones(new ArrayList<>());

        Mockito.when(service.create(any(PlaylistDTO.class))).thenReturn(created);

        String json = objectMapper.writeValueAsString(dto);

        mockMvc.perform(post("/lists")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre").value("Mi lista"))
                .andExpect(jsonPath("$.descripcion").value("Descripción"));
    }

    @Test
    void findAll_return200() throws Exception {
        PlaylistDTO dto = new PlaylistDTO();
        dto.setNombre("Mi lista");
        dto.setDescripcion("Descripción");
        dto.setCanciones(new ArrayList<>());

        List<PlaylistDTO> list = List.of(dto);
        Mockito.when(service.findAll()).thenReturn(list);

        mockMvc.perform(get("/lists"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Mi lista"))
                .andExpect(jsonPath("$[0].descripcion").value("Descripción"));
    }

    @Test
    void findByName_return200() throws Exception {
        PlaylistDTO dto = new PlaylistDTO();
        dto.setNombre("Mi lista");
        dto.setDescripcion("Descripción");
        dto.setCanciones(new ArrayList<>());

        Mockito.when(service.findByName("Mi lista")).thenReturn(dto);

        mockMvc.perform(get("/lists/Mi lista"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Mi lista"))
                .andExpect(jsonPath("$.descripcion").value("Descripción"));
    }

    @Test
    void delete_return204() throws Exception {
        Mockito.doNothing().when(service).delete("Mi lista");

        mockMvc.perform(delete("/lists/Mi lista")
                        .with(csrf()))
                .andExpect(status().isNoContent());
    }
}
