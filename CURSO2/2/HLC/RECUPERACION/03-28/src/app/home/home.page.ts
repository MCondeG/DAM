import { Component } from '@angular/core';
import { ApiServiceProvider } from 'src/providers/api-service/api-service';
import { Movie } from '../modelo/Movie';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})

export class HomePage {

  movies: Movie[] = new Array();
  movieName: string;


  constructor(private apiService: ApiServiceProvider) {}



  buscarPelicula(nombre) {
    console.log(nombre)
    this.apiService.getMovies(nombre)
      .then((movie: Movie[]) => {
        this.movies = movie
      })
      .catch((error: string) => {
        console.log(error);
      });
  }
}