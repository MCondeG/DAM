import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  num:number;
  mayorMenor: string = '...';
  numSecret: number = this.numAleatorio(0,100);

  constructor() {}

  numAleatorio(a,b){
    return Math.round(Math.random() * (b - a) + parseInt(a, 10));
  }

  compruebaNumero(){
    if(this.num)  //si el usuario ya ha introducido un número
    {
      if(this.numSecret < this.num)  //el número introducido es mayor que el número secreto
      {
        this.mayorMenor = 'menor que';   //muestra un texto siciendo que el número secreto es menor
      }
      else if(this.numSecret > this.num)   //el número introducido es menor 
      {
        this.mayorMenor = 'mayor que';    //muestra texto diciendo que el número secreto es mayor
      }
      else{    //el número introducido es igual al número secreto
        this.mayorMenor = '';    //no muestra texto alguno
      }
    }
  }

  reinicia(){
    this.num=null;
    this.mayorMenor = '...';
    this.numSecret = this.numAleatorio(0,100);
  }

}
