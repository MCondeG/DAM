import { Component } from '@angular/core';
import { ApiServiceProvider } from 'src/providers/api-service/api-service';
import { Pelicula } from '../modelo/Pelicula';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})

export class HomePage {

  movies: Pelicula[] = new Array();
  movieName: string;


  constructor(private apiService: ApiServiceProvider) {}


  getMovies() {
    this.apiService.getMovies(this.movieName)
      .then((data: any) => {
        this.characters = data.characters;
        this.totalCharacters = data.total;
        this.offset=data.offset;
        //si el offset es 0, 10 elementos por página y hay 10 personajes
        //(0+10) < 10    da falso, por tanto es la última página
        if ((this.offset + this.elementosPorPagina) < this.totalCharacters) {
          this.ultimaPagina = false;
        }
        else {
          this.ultimaPagina = true;
        }
      })
      .catch((error: string) => {
        console.log(error);
        this.characters=new Array();
        this.offset=0;
      });
  }

  searchNameClick(){
    this.offset=0;
    this.getCharacters();
  }
}