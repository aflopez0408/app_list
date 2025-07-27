import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; // ✅ IMPORTA ESTO
import { PlaylistCreateComponent } from './components/playlist-create/playlist-create.component';
import { PlaylistListComponent } from './components/playlist-list/playlist-list.component';
import { PlaylistSearchComponent } from './components/playlist-search/playlist-search.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule, 
    PlaylistCreateComponent,
    PlaylistListComponent,
    PlaylistSearchComponent
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  vista: 'crear' | 'buscar' | 'listar' | null = null;

  mostrar(v: 'crear' | 'buscar' | 'listar') {
    this.vista = v;
    console.log('Vista activa:', v);
  }
}



