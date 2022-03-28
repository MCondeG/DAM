import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { NavigationExtras } from '@angular/router';
import { NavController } from '@ionic/angular';
import * as moment from 'moment';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  validations_form: FormGroup;
  edad: number;
  constructor(public formBuilder: FormBuilder,
    private navCtrl: NavController) { }

  

  ngOnInit() {
    this.validations_form = this.formBuilder.group({
      dni: new FormControl('', Validators.compose([
        this.validDNI,
        Validators.maxLength(9),
        Validators.minLength(9),
        Validators.pattern('^([0-9]{8,8}[A-Za-z])?$'),
        Validators.required
      ])),
      fechaNacimiento: new FormControl('', Validators.compose([
        Validators.pattern('^([0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2})+$'),
        Validators.required
      ])),
    });
  }//end_ngOnInit

   


  validDNI(fc: FormControl) {
    if (fc.value.trim() === "")
      return (null);
    var letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    var numeros = fc.value.substring(0, fc.value.length - 1);
    var numero = numeros % 23;
    var letraCorr = letras.charAt(numero);
    var letra = fc.value.substring(8, 9).toUpperCase();
    if (letraCorr != letra) {
      return ({ validDNI: true });
    } else {
      return (null);
    }
  }

  onSubmit(values) {
    console.log(values);
    let navigationExtras: NavigationExtras = {
      queryParams: {
        user: JSON.stringify(values)
       
      }
      
    };
    this.navCtrl.navigateForward('/pagina2', navigationExtras);
  }

  validarGrupoDatosUsuario() {
    let newDate = new Date(this.validations_form.get('fechaNacimiento').value);
    var fechaNacimiento: Date = newDate;
    var dni: string = this.validations_form.get('dni').value;
    var edad: number;

    if (!fechaNacimiento) return { validarGrupoDatosUsuario: true };

    edad = moment().diff(fechaNacimiento, 'years');
    console.log(edad)
    /*if (edad < 22) return null;
    else {
      if (dni === '') return { validarGrupoDatosUsuario: true };
      else return null;
    }*/
  }

}
