import { Component } from '@angular/core';
import { PlaylistCreateComponent } from './components/playlist-create/playlist-create.component';
import { PlaylistListComponent } from './components/playlist-list/playlist-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [PlaylistCreateComponent, PlaylistListComponent],
  template: `
    <app-playlist-create></app-playlist-create>
    <hr />
    <app-playlist-list></app-playlist-list>
  `
})
export class AppComponent {}
