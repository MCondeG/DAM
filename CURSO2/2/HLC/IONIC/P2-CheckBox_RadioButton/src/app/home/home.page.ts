import { formatNumber } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  apellidos:string="";
  nombre:string="";
  provincia:string="";
  estadoCivil:string="";
  famNum:boolean;

  boton:HTMLButtonElement;

  constructor() {}

  ionViewWillEnter(){
    this.boton = <HTMLButtonElement>document.getElementById("boton");
  }


  desactivarBoton() {

    return (!(this.apellidos.trim()!=''
    && this.nombre.trim()!=''
    && this.provincia.trim()!=''
    && this.estadoCivil=='casado'
    && this.famNum
  ));
  }
}