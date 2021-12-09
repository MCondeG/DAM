import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  pulsadoBoton1:boolean=false;
  pulsadoBoton2:boolean=false;
  input1:HTMLInputElement;
  input2:HTMLInputElement;
  input3:HTMLInputElement;
  boton1:HTMLButtonElement;
  boton2:HTMLButtonElement;
  boton3:HTMLButtonElement;

  constructor() {
    //vacio   
  }

  ionViewWillEnter(){
    this.input1=<HTMLInputElement>document.getElementById("input1");
    this.boton1=<HTMLButtonElement>document.getElementById("boton1");
  }

  clickBoton1(){
    if(this.input1.value){  //si tiene algun valor (no es null)
      this.pulsadoBoton1=true;
      this.input1.disabled=true;
      this.boton1.disabled=true;
    }
  }

  clickBoton2(){
    this.input2=<HTMLInputElement>document.getElementById("input2");
    this.boton2=<HTMLButtonElement>document.getElementById("boton2");
    if(this.input2.value){  //si tiene algun valor (no es null)
      this.pulsadoBoton2=true;
      this.input2.disabled=true;
      this.boton2.disabled=true;
    }
  }

  clickBoton3(){
    this.input3=<HTMLInputElement>document.getElementById("input3");
    this.boton3=<HTMLButtonElement>document.getElementById("boton3");
    if(this.input3.value){  //si tiene algun valor (no es null)
      this.input3.disabled=true;
      this.boton3.disabled=true;
    }
  }

}
