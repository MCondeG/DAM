import { Component } from '@angular/core';
import { NavigationExtras } from '@angular/router';
import { NavController } from '@ionic/angular';
import { Alumno } from '../modelo/Alumno';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  public mayorEdad: boolean = false;
  public menorEdad: boolean = false;
  public alumno: Alumno = new Alumno();

  constructor(private navCtrl: NavController) { }

  cambiaEdad() {
    if (this.alumno.edad > 17) {
      this.mayorEdad = true;
      this.menorEdad = false;
    } else if (this.alumno.edad < 18) {
      this.mayorEdad = false;
      this.menorEdad = true;
    }
  }

  datosCorrectos() {
    if (this.alumno.apellidos == null ||
      this.alumno.nombre == null ||
      this.alumno.sexo == null ||
      this.alumno.edad == null) {
      return false;
    }
    
    if (this.alumno.edad < 18) {
      if (this.alumno.dniMadre == null ||
        this.alumno.apellidosMadre == null ||
        this.alumno.dniPadre == null ||
        this.alumno.apellidosPadre == null) {
        return false;
      }
    }//if edad < 18
    
    if (this.alumno.edad >= 18) {
      if (this.alumno.trabaja == null ||
        this.alumno.dni == null ||
        this.alumno.estadoCivil == null) {
        return false;
      }
    }//if edad>=18

    //si llega aquí significa que se han introducido todos los campos
    return true;
  }

  enviarDatos() {

    let navigationExtras: NavigationExtras = {
      queryParams: {
        alumno: JSON.stringify(this.alumno)
      }
    };
    console.log(this.alumno);
    this.navCtrl.navigateForward('/pagina2', navigationExtras);

  }
}
