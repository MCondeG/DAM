import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { NavigationExtras } from '@angular/router';
import { NavController } from '@ionic/angular';
import * as moment from 'moment';
import { Usuario } from '../modelo/Usuario';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  validations_form: FormGroup;
  formGroupFechaNacimientoDni: FormGroup;

  validation_messages = {
    'apellidosNombre': [
      { type: 'required', message: 'falta apellidos y nombre' },
      { type: 'maxlength', message: 'no puede exceder de 80 caracteres' },
      { type: 'pattern', message: 'solo se admiten letras en mayúsculas o minúsculas' }
    ],
    'fechaNacimiento': [
      { type: 'required', message: 'falta la fecha de nacimiento' },
      { type: 'validarFechaNacimiento', message: 'la fecha de nacimiento no puede ser posterior a la fecha actual' }
    ],
    'dni': [
      { type: 'pattern', message: 'dni debe tener 9 dígitos y 1 letra' },
      { type: 'validDNI', message: 'la letra del dni no es correcta' }
    ],
    'formGroupFechaNacimientoDni': [
      { type: 'validarFechaNacimientoDni', message: 'dni obligatorio para mayores de 18 años' }
    ]
  };

  constructor(
    public formBuilder: FormBuilder,
    private navCtrl: NavController
  ) { }

  ngOnInit() {

    this.formGroupFechaNacimientoDni = new FormGroup({
      fechaNacimiento: new FormControl('', Validators.compose([
        this.validarFechaNacimiento,
        Validators.required
      ])),
      dni: new FormControl('', Validators.compose([
        this.validDNI,
        Validators.pattern('[0-9]{8,8}[A-Za-z]')
      ]))
    }, (formGroup: FormGroup) => {
      return this.validarFechaNacimientoDni(formGroup);
    });

    this.validations_form = this.formBuilder.group({
      apellidosNombre: new FormControl('', Validators.compose([
        Validators.maxLength(80),
        Validators.pattern('[A-Za-záéíóúÁÉÍÓÚ]+'),
        Validators.required
      ])),
      formGroupFechaNacimientoDni: this.formGroupFechaNacimientoDni
    });
  }//end ngOnInit

  validDNI(fc: FormControl) {
    if (fc.value === '') {  //el dni puede estar vacío
      return null;
    }
    var letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    var numeros = fc.value.substring(0, fc.value.length - 1);
    var numero = numeros % 23;
    var letraCorr = letras.charAt(numero);
    var letra: string = fc.value.substring(8, 9).toUpperCase();
    if (letraCorr != letra) {
      return ({ validDNI: true });
    } else {
      return (null);
    }
  }//end validDNI

  validarFechaNacimiento(fc: FormControl) {
    let fechaHoraActual: Date = new Date();
    let fechaActual: moment.Moment = moment(fechaHoraActual.getFullYear() + "/" + (fechaHoraActual.getMonth() + 1) + "/" + fechaHoraActual.getDate(), 'YYYY/MM/DD');
    let fechaFormulario: moment.Moment = moment(fc.value, 'YYYY/MM/DD');
    if (fechaActual.toDate().getTime() < fechaFormulario.toDate().getTime()) {  //milisegundos desde 1970
      //la fecha introducida es mayor que la actual - la fecha no es válida
      return ({ validarFechaNacimiento: true });
    }
    else {
      //la fecha introducida es menor o igual a la actual - la fecha es válida
      return (null);
    }
  }//end validaFechaNacimiento

  validarFechaNacimientoDni(fg: FormGroup) {
    let fechaHoraActual: Date = new Date();
    let fechaActual: moment.Moment = moment(fechaHoraActual.getFullYear() + "/" + (fechaHoraActual.getMonth() + 1) + "/" + fechaHoraActual.getDate(), 'YYYY/MM/DD');
    let fechaFormulario: moment.Moment = moment(fg.get('fechaNacimiento').value, 'YYYY/MM/DD');
    let annosEdad = fechaActual.diff(fechaFormulario, 'years'); //calcula la edad en años
    if (annosEdad >= 18 && fg.get('dni').value === "") {
      //es mayor de edad y no se ha escrito un dni
      return ({ validarFechaNacimientoDni: true });
    }
    else {
      //es menor de 18 años
      //es válido aunque no halla puesto el dni
      return (null);
    }
  }//end validarFechaNacimiento

  onSubmit(valores: any) {
    let usuario = new Usuario(valores.apellidosNombre,
      valores.formGroupFechaNacimientoDni.fechaNacimiento,
      valores.formGroupFechaNacimientoDni.dni.toUpperCase());
    console.log(usuario);
    let navigationExtras: NavigationExtras = {
      queryParams: {
        usuario: JSON.stringify(usuario),
      }
    };
    this.navCtrl.navigateForward('/pagina2', navigationExtras);
  }

}//end_class