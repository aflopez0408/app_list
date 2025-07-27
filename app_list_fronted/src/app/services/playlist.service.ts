import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface SongDTO {
  titulo: string;
  artista: string;
  album: string;
  anno: number;
  genero: string;
}

export interface PlaylistDTO {
  nombre: string;
  descripcion: string;
  canciones: SongDTO[];
}

@Injectable({
  providedIn: 'root'
})
export class PlaylistService {

  private apiUrl = 'http://localhost:8080/lists'; // CORREGIDO

  constructor(private http: HttpClient) {}

  crearPlaylist(data: PlaylistDTO): Observable<PlaylistDTO> {
    return this.http.post<PlaylistDTO>(this.apiUrl, data);
  }

  obtenerTodas(): Observable<PlaylistDTO[]> {
    return this.http.get<PlaylistDTO[]>(this.apiUrl);
  }

  buscarPorNombre(nombre: string): Observable<PlaylistDTO> {
  return this.http.get<PlaylistDTO>(`${this.apiUrl}/${nombre}`);
  }

}


