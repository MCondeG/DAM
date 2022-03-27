import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  ciclos: string[]=["DAM", "DAW", "ASIR"];

  curso:string="";
  curso_eso:string="";
  ciclo:string="";

  constructor() {}

  clickBoton1(){
    console.log();
  }

}
