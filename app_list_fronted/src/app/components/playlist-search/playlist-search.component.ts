import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { PlaylistService, PlaylistDTO } from '../../services/playlist.service';

@Component({
  selector: 'app-playlist-search',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './playlist-search.component.html',
  styleUrls: ['./playlist-search.component.css']
})
export class PlaylistSearchComponent {
  searchForm: FormGroup;
  playlistEncontrada: PlaylistDTO | null = null;

  constructor(
    private fb: FormBuilder,
    private playlistService: PlaylistService
  ) {
    this.searchForm = this.fb.group({
      nombre: ['']
    });
  }

  buscar() {
    const nombre = this.searchForm.value.nombre.trim();
    if (!nombre) return;

    this.playlistService.buscarPorNombre(nombre).subscribe({
      next: (res) => {
        this.playlistEncontrada = res;
      },
      error: (err) => {
        console.error(err);
        alert('No se encontró la playlist');
        this.playlistEncontrada = null;
      }
    });
  }

  eliminar(nombre: string) {
    if (confirm(`¿Estás seguro de eliminar la playlist "${nombre}"?`)) {
      this.playlistService.eliminarPorNombre(nombre).subscribe({
        next: () => {
          alert('Playlist eliminada');
          this.playlistEncontrada = null;
          this.searchForm.reset();
        },
        error: (err) => {
          alert('Error al eliminar');
          console.error(err);
        }
      });
    }
  }
}

