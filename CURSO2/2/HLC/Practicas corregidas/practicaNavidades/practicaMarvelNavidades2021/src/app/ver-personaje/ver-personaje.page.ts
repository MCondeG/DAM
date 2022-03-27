import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationExtras } from '@angular/router';
import { NavController } from '@ionic/angular';
import { ApiServiceProvider } from 'src/providers/api-service/api-service';
import { Character } from '../modelo/Character';
import { Comic } from '../modelo/Comic';

@Component({
  selector: 'app-ver-personaje',
  templateUrl: './ver-personaje.page.html',
  styleUrls: ['./ver-personaje.page.scss'],
})
export class VerPersonajePage implements OnInit {

  character:Character;
  comics:Comic[]=new Array();

  constructor(private activatedRoute: ActivatedRoute, 
              private apiService:ApiServiceProvider,
              private navCtrl:NavController) {
    this.activatedRoute.queryParams.subscribe(params => {
      this.character = JSON.parse(params["character"]);
      console.log(this.character);
    });
  }
  ngOnInit() {
    this.getComics();
  }

  getComics() {
    this.apiService.getComics(this.character.id)
      .then((data: Comic[]) => {
        this.comics = data;
      })
      .catch((error: string) => {
        console.log(error);
      });
  }

  comicClick(indice:number){
    let navigationExtras: NavigationExtras = {
      queryParams: {
        comic: JSON.stringify(this.comics[indice])
      }
    };
    this.navCtrl.navigateForward('/ver-comic', navigationExtras);
  }

}
