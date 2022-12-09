import { Component } from '@angular/core';
import { Partido } from '../modelo/Partido';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})

export class HomePage {

  checked: boolean;
  marcador: boolean;
  edit1: boolean;
  edit2: boolean;
  equipos: string[];
  partidos: Partido[];
  partidoSeleccionado: Partido;


  constructor() {

    this.checked = false;
    this.marcador = false;
    this.edit1 = false;
    this.edit2 = false;
    this.partidoSeleccionado = new Partido("", "", 0, 0);

    this.equipos = [
      "SANTA CLARA",
      "SAFAUR",
      "BETIS ESPARTINAS",
      "SIDERAL",
      "FRESAS",
      "MAIRENA DEL ALJARAFE"
    ];

    this.partidos = [
      new Partido("SANTA CLARA", "SAFAUR" , 36 , 42),
      new Partido("SIDERAL", "BETIS ESPARTINAS" , 50 , 46),
      new Partido("MAIRENA DEL ALJARAFE", "FRESAS" , 66 , 49),
    ];
  }

  
  checkBoxNuevoPartido() {

    this.checked = !this.checked;
  }

  clickEditarMarcador(i: number) {

    this.marcador = true;
    this.partidoSeleccionado = this.partidos[i];
  }

  editar(local: boolean) {

    if (local) this.edit1 = !this.edit1;
    else this.edit2 = !this.edit2;
  }

  suma(local: boolean, puntos: number) {

    if (local) this.partidoSeleccionado.puntosLocal += puntos;
    else this.partidoSeleccionado.puntosVisitante += puntos;
  }

  volver() {

    this.marcador = false;
    this.edit1 = false;
    this.edit2 = false;
  }
}