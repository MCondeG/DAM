import { Component, OnInit } from '@angular/core';
import { ApiServiceProvider } from 'src/providers/api-service/api-service';
import { Alumno } from '../modelo/Alumno';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  private alumnos = new Array<Alumno>();

  constructor(private apiService: ApiServiceProvider) {
  }

  /*
  
  cuando se carga la pantalla se llama al método getAlumnos de la Api. Este es un método asíncrono que devuelve un objeto Promise del que debe ser evaluado el resultado.
  
  Si el acceso a la Api ha ido bien se ejecuta el código asociado a la cláusula then.  Símplemente se coge el array de alumnos que llega y se asocia a él el atributo alumnos de la clase.
  
  Si ha ido mal el acceso (por ejemplo si no hemos lanzado jsonServer) se coge el error que llega y se muestra por consola.
  
  */


  ngOnInit(): void {
    this.apiService.getAlumnos()
      .then((alumnos: Alumno[]) => {
        this.alumnos = alumnos;
      })
      .catch((error: string) => {
        console.log(error);
      });
  }


  /*
  
  este método llama al método eliminarAlumno de la Api y le pasa el id del alumno a eliminar. Se devuelve un objeto Promise. Si el borrado ha ido bien se ejecuta el código asociado a la cláusula then. Símplemente se muestra por consola un mensaje y se elimina el alumno del array de alumnos de la clase, lo que hará que deje de verse en la vista.
  
  Si el borrado ha ido mal muestro por consola el error que ha ocurrido.
  
  */
  eliminarAlumno(indice: number) {
    this.apiService.eliminarAlumno(this.alumnos[indice].id)
      .then((correcto: boolean) => {
        console.log("Borrado correcto del alumno con indice: " + indice);
        this.alumnos.splice(indice, 1);
      })
      .catch((error: string) => {
        console.log("Error al borrar: " + error);
      });
  }//end_eliminar_alumno

}//end_class