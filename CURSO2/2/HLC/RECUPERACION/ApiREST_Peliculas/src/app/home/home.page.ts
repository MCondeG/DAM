import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { NavigationExtras } from '@angular/router';
import { NavController } from '@ionic/angular';
import * as moment from 'moment';
import { User } from 'src/modelo/User';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})


export class HomePage {


  validations_form: FormGroup;
  datos: FormGroup;
  validation_messages = {
    'dni': [
      { type: 'validDNI', message: 'La letra no corresponde con los números' },
      { type: 'required', message: 'DNI requerido' },
      { type: 'minlength', message: 'DNI debe tener 9 caracteres' },
      { type: 'maxlength', message: 'DNI debe tener 9 caracteres' },
      { type: 'pattern', message: 'DNI debe tener el patrón correspondiente' }
    ],
    'fechaNacimiento': [
      { type: 'validDate', message: 'Fecha debe ser anterior a 2000-01-01' },
      { type: 'required', message: 'Fecha de nacimiento requerido' },
      { type: 'pattern', message: 'Fecha nacimiento debe tener el patrón correspondiente' }
    ]
  };

  constructor(
    public formBuilder: FormBuilder,
    private navCtrl: NavController
  ) { }

  ngOnInit() {

    this.datos = new FormGroup({
      dni: new FormControl('', Validators.compose([
        this.validDNI,
        Validators.maxLength(9),
        Validators.minLength(9),
        Validators.pattern('[0-9]{8,8}[A-Za-z]'),
        Validators.required
      ])),
      fechaNacimiento: new FormControl('', Validators.compose([
        this.validDate,
        Validators.pattern('^([0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2})+$'),
        Validators.required
      ]))
    });

    this.validations_form = this.formBuilder.group({datos: this.datos});
  }

  onSubmit() {
    let navigationExtras: NavigationExtras = {
      queryParams: {
        user: JSON.stringify(this.datos.value)
      }
    };
    
    this.navCtrl.navigateForward('/pagina2', navigationExtras);
  }

  validDNI(fc: FormControl) {

    var letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    var numeros = fc.value.substring(0, fc.value.length - 1);
    var numero = numeros % 23;
    var letraCorr = letras.charAt(numero);
    var letra = fc.value.substring(8, 9).toUpperCase();

    if (letraCorr != letra) return ({ validDNI: true });
    else return (null);
  
  }

  validDate(fc: FormControl) {

    var fecha: string = fc.value;

    if (moment(fecha).isBefore('2000-01-01')) return null;
    else return ({ validDate: true })
  }
}