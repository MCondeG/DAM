import { Component, OnInit } from '@angular/core';
import { NavParams } from '@ionic/angular';
import { stringify } from 'querystring';
import { Partido } from '../modelo/Partido';

@Component({
  selector: 'app-gestion-partido',
  templateUrl: './gestion-partido.page.html',
  styleUrls: ['./gestion-partido.page.scss'],
})
export class GestionPartidoPage implements OnInit {

  partido: Partido;

  constructor(navParams: NavParams) {

    this.partido = new Partido()

    this.partido.id = navParams.get('idPartido');
    this.partido.equipoLocal = navParams.get('equipoLocal');
    this.partido.equipoVisitante = navParams.get('PartidoVisitante');
    this.partido.puntosLocal = navParams.get('puntosLocal');
    this.partido.puntosVisitante = navParams.get('puntosVisitante');
  }


  ngOnInit() {
    
  }

}