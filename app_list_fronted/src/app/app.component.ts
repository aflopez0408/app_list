import { Component } from '@angular/core';
import { PlaylistCreateComponent } from './components/playlist-create/playlist-create.component';
import { PlaylistListComponent } from './components/playlist-list/playlist-list.component';
import { PlaylistSearchComponent } from './components/playlist-search/playlist-search.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    PlaylistCreateComponent, 
    PlaylistListComponent,
   PlaylistSearchComponent],

  template: `
    <app-playlist-create></app-playlist-create>
    <hr />
    <app-playlist-list></app-playlist-list>
    <hr />
    <app-playlist-search></app-playlist-search>
  `
})
export class AppComponent {}
