import { Component } from '@angular/core';
import { PlaylistCreateComponent } from './components/playlist-create/playlist-create.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [PlaylistCreateComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {}