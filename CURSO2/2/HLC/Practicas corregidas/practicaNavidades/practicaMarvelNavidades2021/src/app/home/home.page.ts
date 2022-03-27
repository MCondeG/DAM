import { Component } from '@angular/core';
import { NavigationExtras } from '@angular/router';
import { NavController } from '@ionic/angular';
import { ApiServiceProvider } from 'src/providers/api-service/api-service';
import { Character } from '../modelo/Character';
import { Comic } from '../modelo/Comic';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  characters: Character[] = new Array();
  elementosPorPagina: number = 10;
  offset: number = 0;
  totalCharacters: number;
  ultimaPagina: boolean;
  primeraPagina: boolean;
  characterName:string;

  constructor(private apiService: ApiServiceProvider,
              private navCtrl:NavController){  
  }

  ngOnInit(): void {
    this.getCharacters();
  }//end_ngOninit

  paginaSiguiente() {
    if (!this.ultimaPagina) {
      this.offset += this.elementosPorPagina;
      this.getCharacters();
    }
  }

  paginaAnterior() {
    if (!this.primeraPagina) {
      this.offset -= this.elementosPorPagina;
      this.getCharacters();
    }
  }

  irPrimeraPagina() {
    this.offset = 0;
    this.getCharacters();
  }

  irUltimaPagina() {
    this.offset = Math.trunc(this.totalCharacters / this.elementosPorPagina) * this.elementosPorPagina;
    if(this.offset==this.totalCharacters){
      this.offset-=this.elementosPorPagina;
    }
    this.getCharacters();
  }

  getCharacters() {
    if (this.offset == 0) {
      this.primeraPagina = true;
    }
    else {
      this.primeraPagina = false;
    }
    this.apiService.getCharacters(this.elementosPorPagina, this.offset, this.characterName)
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

  characterClick(indice:number){
    let navigationExtras: NavigationExtras = {
      queryParams: {
        character: JSON.stringify(this.characters[indice])
      }
    };
    this.navCtrl.navigateForward('/ver-personaje', navigationExtras);
  }

}//end_class
