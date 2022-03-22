import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { NavigationExtras } from '@angular/router';
import { NavController } from '@ionic/angular';
import * as moment from 'moment';
import { Moment } from 'moment';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})

export class HomePage implements OnInit {

  validations_form: FormGroup;
  datos: FormGroup;
  validation_messages = {
    'DNI': [
      { type: 'validDNI', message: 'La letra no corresponde con los números' },
      { type: 'required', message: 'DNI requerido' },
      { type: 'minlength', message: 'DNI debe tener 9 caracteres' },
      { type: 'maxlength', message: 'DNI debe tener 9 caracteres' },
      { type: 'pattern', message: 'DNI debe tener el patrón correspondiente' },
    ],
    'FECHA': [
      { type: 'required', message: 'Fecha de nacimiento requerido' }
    ]
  };

  constructor(
    public formBuilder: FormBuilder,
    private navCtrl: NavController
  ) { }

  ngOnInit() {

    this.datos = new FormGroup({
      DNI: new FormControl('', Validators.compose([
        this.validDNI,
        Validators.maxLength(9),
        Validators.minLength(9),
        Validators.pattern('[0-9]{8,8}[A-Za-z]'),
        Validators.required
      ])),
      FECHA: new FormControl('', Validators.required)
    }, (formGroup: FormGroup) => {
      return this.FechaValida(formGroup);
    });

    this.validations_form = this.formBuilder.group({
      datos: this.datos
    });
  }

  onSubmit(values) {
    console.log(values);
    let navigationExtras: NavigationExtras = {
      queryParams: {
        user: JSON.stringify(values),
      }
    };
    this.navCtrl.navigateForward('/datos', navigationExtras);
  }

  validDNI(fc: FormControl) {
    var letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    var numeros = fc.value.substring(0, fc.value.length - 1);
    var numero = numeros % 23;
    var letraCorr = letras.charAt(numero);
    var letra = fc.value.substring(8, 9);
    if (letraCorr != letra) {
      return ({ validDNI: true });
    } else {
      return (null);
    }
  }

  FechaValida (fg: FormGroup) {

    var fecha: string = fg.controls['FECHA'].value;

    if ((moment(fecha).isBefore('2000-01-01')) && (this.validations_form.get('datos').get('DNI').valid)) return null;
    else return {datos: true};
  }
}