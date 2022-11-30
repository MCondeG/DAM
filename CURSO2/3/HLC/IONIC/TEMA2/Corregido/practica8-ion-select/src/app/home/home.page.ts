import { Component } from '@angular/core';
import { AlumnoAsignatura } from '../modelo/AlumnoAsignatura';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  private asignaturas:string[]=['HLC','MÓVILES','ACCESO A DATOS'];
  private alumnos:string[]=['Perez López, Marta', 'García Aranda, José', 'Nieto Blanco, Ana'];
  private alumnosSeleccionados:string[];
  private alumnosAsignaturas: AlumnoAsignatura[];
  private asignaturaSeleccionada:string;

  constructor() {}

  cambiaAsignatura(event){
    console.log(event.target.value);
    console.log(this.asignaturaSeleccionada);
  }

  seleccionadosAlumnos(event){
    console.log(this.alumnosSeleccionados);
    this.alumnosAsignaturas=[];
    this.alumnosSeleccionados.forEach((alumno:string)=>{
      this.alumnosAsignaturas.push(new AlumnoAsignatura(alumno,this.asignaturaSeleccionada));
    })
  }

}//end_class
