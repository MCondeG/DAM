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
export class HomePage implements OnInit{

  formulario: FormGroup;
  grupoDatosUsuario: FormGroup;

  validation_messages = {
    'dniUsuario': [
      { type: 'validDNI', message: 'letra incorrecta' },
      { type: 'required', message: 'DNI requerido' },
      { type: 'minlength', message: 'DNI debe tener 9 caracteres' },
      { type: 'maxlength', message: 'DNI debe tener 9 caracteres' },
      { type: 'pattern', message: 'patrón incorrecto' },
    ],
    'apellidosNombreUsuario': [
      { type: 'required', message: 'apellidos y nombre requeridos' },
    ],
    'fechaNacimientoUsuario': [
      { type: 'required', message: 'fecha de nacimiento requerido' }
    ],
    'grupoDatosUsuario': [
      { type: 'validarGrupoDatosUsuario', message: 'Es obligatorio introducir el DNI por ser mayor de 18' }
    ]
  };

  constructor(public formBuilder: FormBuilder,
    private navCtrl: NavController) {
  }

  ngOnInit() {
    this.grupoDatosUsuario = new FormGroup({
      fechaNacimientoUsuario: new FormControl('', Validators.compose([
        Validators.required
      ])),
      apellidosNombreUsuario: new FormControl('',Validators.compose([
        Validators.required,
      ])),
      dniUsuario: new FormControl('',Validators.compose([
        this.validDNI,
        Validators.maxLength(9),
        Validators.pattern('^([0-9]{8,8}[A-Za-z])?$')
      ])),
    }, (formGroup: FormGroup) => {
      return this.validarGrupoDatosUsuario(formGroup);
    });
  
    this.formulario = this.formBuilder.group({
      grupoDatosUsuario : this.grupoDatosUsuario
    });
  }

  onSubmit(values){

    let usuario:Usuario;
    usuario = new Usuario(values['grupoDatosUsuario']['dniUsuario'].toUpperCase(),
      values['grupoDatosUsuario']['apellidosNombreUsuario'],
      values['grupoDatosUsuario']['fechaNacimientoUsuario']
    );
    let navigationExtras: NavigationExtras = {
      queryParams: {
          usuario: JSON.stringify(usuario)
      }
    };
    this.navCtrl.navigateForward('/pagina2', navigationExtras);
  }

  

  validarGrupoDatosUsuario(fg: FormGroup){
    var fechaNacimiento: string=fg.controls['fechaNacimientoUsuario'].value;
    var dni: string=fg.controls['dniUsuario'].value;
    var edad: number;

    if(!fechaNacimiento) return {validarGrupoDatosUsuario: true};

    edad = moment().diff(fechaNacimiento, 'years');
    console.log(edad);

    if( edad < 18) return null;
    else{
      if(dni === '') return {validarGrupoDatosUsuario: true};
      else return null;
    }
  }

  validDNI(fc: FormControl) {

    if(fc.value==='') return null;

    var letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    var numeros = fc.value.substring(0, fc.value.length - 1);
    var numero = numeros % 23;
    var letraCorr = letras.charAt(numero);
    var letra = fc.value.substring(8, 9).toUpperCase();

    if (letraCorr != letra) return ({ validDNI: true });
    else return (null);
  }
}