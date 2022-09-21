import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  tipoEstudios:string=null;
  cursoEso:string=null;
  repiteEso:boolean=false;
  ciclo:string=null;
  listaCiclos:string[]=["DAM", "DAW", "ASIR"];
  mensaje:string="";

  constructor() {}

  clickBotonEso(){
    console.log(this.tipoEstudios+" - "+this.cursoEso+" - "     + (this.repiteEso ? "repite" : "no repite"));
  }

  clickBotonCiclo(){
    console.log(this.tipoEstudios+" - "+this.ciclo);
  }

}
