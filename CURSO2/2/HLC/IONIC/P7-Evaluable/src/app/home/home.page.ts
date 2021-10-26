import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  radio1: string;
  radio2: string;
  checkbox: boolean;
  ciclo: string;
  ciclos: string[];
  boton: HTMLButtonElement;


  constructor() {
    
    this.radio1 = null;
    this.radio2 = null;
    this.checkbox = false;
    this.ciclo = null;
    this.ciclos = ["DAM", "DAW", "ASIR"];
  }

  ionViewWillEnter(){
    this.boton = <HTMLButtonElement>document.getElementById("boton");
  }


  mostrarCurso() {

    if (this.radio1 == "ESO") return true;
    else return false;
  }

  mostrarCiclo() {

    if (this.radio1 == "CICLO") return true;
    else return false;
  }

  mostrarBoton() {

    if (this.radio1 == null) return false;
    else return true;
  }

  activarBoton() {

    if ((this.radio2 == null) && (this.ciclo == null)) return true;
    else return false;
  }

  clickBoton() {

    console.clear();
    console.log(this.radio1);

    if (this.radio1 == "ESO") {
      console.log(this.radio2);
      console.log(this.checkbox);
    }
    else console.log(this.ciclo);
  }
}