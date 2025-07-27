import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PlaylistService, PlaylistDTO } from '../../services/playlist.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-playlist-list',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './playlist-list.component.html',
  styleUrls: ['./playlist-list.component.css']
})
export class PlaylistListComponent implements OnInit {
  playlists: PlaylistDTO[] = [];

  constructor(private playlistService: PlaylistService) {}

  ngOnInit(): void {
    this.playlistService.obtenerTodas().subscribe({
      next: (data) => {
        this.playlists = data;
      },
      error: (err) => {
        console.error('Error al obtener playlists', err);
      }
    });
  }
}
