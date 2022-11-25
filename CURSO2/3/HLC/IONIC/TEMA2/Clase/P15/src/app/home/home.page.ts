import { Component } from '@angular/core';
import { Alumno } from '../modelo/alumno';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})


export class HomePage {

  private alumno: Alumno;

  constructor() {
    this.alumno = new Alumno();
  }

  public prueba() {

    console.log(this.alumno.nombre);
    console.log(this.alumno.apellido);
    console.log(this.alumno.sexo);
  }
}