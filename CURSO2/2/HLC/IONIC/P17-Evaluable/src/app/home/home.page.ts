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
      { type: 'validDNI', message: 'La letra no corresponde con los números' },
      { type: 'required', message: 'DNI es requerido' },
      { type: 'minlength', message: 'DNI debe tener 9 caracteres' },
      { type: 'maxlength', message: 'DNI debe tener 9 caracteres' },
      { type: 'pattern', message: 'DNI debe tener el patrón correspondiente' },
    ],
    'apellidosNombreUsuario': [
      { type: 'required', message: 'apellidos y nombre es requerido' },
      { type: 'maxlength', message: 'apellidos y nombre debe tener 80 caracteres como máximo' },
      { type: 'pattern', message: 'apellidos y nombre solo puede contener letras' }
    ],
    'fechaNacimientoUsuario': [
      { type: 'required', message: 'fecha de nacimiento es requerido' }
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
        Validators.maxLength(80),
        Validators.pattern('[A-Za-z\\s]+')
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
    usuario=new Usuario(values['grupoDatosUsuario']['dniUsuario'].toUpperCase(),
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
    var fechaNacimiento:string=fg.controls['fechaNacimientoUsuario'].value;
    var dni:string=fg.controls['dniUsuario'].value;
    var edad:number;

    if(!fechaNacimiento) //si no hay valor en la fecha de nacimiento no se valida
        return {validarGrupoDatosUsuario:true};

    //se hace uso de la libreria moment de javascript
    //se instala con:   npm install moment
    //para usarla aquí hay que importarla: import * as moment from 'moment';
    edad = moment().diff(fechaNacimiento, 'years');
    console.log(edad);
    if(edad<18){
      //no hace falta introducir dni porque el alumno es menor de 18
      return null;   //se valida
    }
    else{ //el alumno es mayor de 18
      //es obligatorio introducir el dni
      if(dni==='')  //no se ha introducido dni
        return {validarGrupoDatosUsuario:true};  //no se valida
      else
        return null;  //se valida
    }
  }

  validDNI(fc: FormControl) {
    if(fc.value===''){
      return null;  //se valida
    }
    var letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    var numeros = fc.value.substring(0, fc.value.length - 1);
    var numero = numeros % 23;
    var letraCorr = letras.charAt(numero);
    var letra = fc.value.substring(8, 9).toUpperCase();
    if (letraCorr != letra) {
      return ({ validDNI: true });  //no se valida
    } else {
      return (null);  //se valida
    }
  }

}
