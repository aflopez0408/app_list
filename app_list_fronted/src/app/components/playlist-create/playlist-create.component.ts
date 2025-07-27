import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, FormArray, Validators } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { PlaylistService } from '../../services/playlist.service'; 

@Component({
  selector: 'app-playlist-create',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, HttpClientModule],
  templateUrl: './playlist-create.component.html',
  styleUrls: ['./playlist-create.component.css']
})
export class PlaylistCreateComponent {
  form: FormGroup;

  constructor(private fb: FormBuilder, private playlistService: PlaylistService) {
    this.form = this.fb.group({
      nombre: ['', Validators.required],
      descripcion: [''],
      canciones: this.fb.array([])
    });
  }

  get canciones(): FormArray {
    return this.form.get('canciones') as FormArray;
  }

  agregarCancion() {
    this.canciones.push(this.fb.group({
      titulo: ['', Validators.required],
      artista: ['', Validators.required],
      album: [''],
      anno: [''],
      genero: ['']
    }));
  }

  eliminarCancion(index: number) {
    this.canciones.removeAt(index);
  }

  onSubmit() {
  if (this.form.invalid) {
    alert('Completa todos los campos requeridos.');
    return;
  }

  console.log('Enviando datos:', this.form.value);

  this.playlistService.crearPlaylist(this.form.value).subscribe({
    next: () => {
      alert('¡Lista creada con éxito!');
      this.form.reset();
      this.canciones.clear();
    },
    error: (err: any) => { // ✅ Aquí es donde se corrige
      alert('Error al crear la lista');
      console.error(err);  // Esto ya lo tenías bien
    }
  });
}
}


