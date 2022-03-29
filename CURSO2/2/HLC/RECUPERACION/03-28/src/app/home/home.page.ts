import { Component } from '@angular/core';
import { ApiService } from 'src/providers/api-service/api-service';
import { Movie } from '../modelo/Movie';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})

export class HomePage {

  movies: Movie[] = new Array();
  movieName: string;


  constructor(private apiService: ApiService) {}


  buscarPelicula() {
    this.apiService.getMovies(this.movieName)
      .then((busqueda: Movie[]) => {
        this.movies = busqueda;
      })
      .catch((error: string) => {
        console.log(error);
      });
  }
}