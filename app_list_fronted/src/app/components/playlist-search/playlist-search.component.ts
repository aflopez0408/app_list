import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PlaylistService, PlaylistDTO } from '../../services/playlist.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-playlist-search',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './playlist-search.component.html',
  styleUrls: ['./playlist-search.component.css']
})
export class PlaylistSearchComponent {
  nombre: string = '';
  resultado: PlaylistDTO | null = null;
  error: string | null = null;

  constructor(private playlistService: PlaylistService) {}

  buscar() {
    if (!this.nombre.trim()) {
      return;
    }

    this.playlistService.buscarPorNombre(this.nombre.trim()).subscribe({
      next: (playlist) => {
        this.resultado = playlist;
        this.error = null;
      },
      error: () => {
        this.resultado = null;
        this.error = `No se encontró ninguna playlist con el nombre "${this.nombre}"`;
      }
    });
  }
}
