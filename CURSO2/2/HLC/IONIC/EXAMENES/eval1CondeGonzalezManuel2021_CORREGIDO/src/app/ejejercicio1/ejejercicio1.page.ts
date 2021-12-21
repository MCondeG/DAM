import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Usuario } from '../modelo/Usuario';

@Component({
  selector: 'app-ejejercicio1',
  templateUrl: './ejejercicio1.page.html',
  styleUrls: ['./ejejercicio1.page.scss'],
})
export class Ejejercicio1Page implements OnInit {

  formulario: FormGroup;

  constructor(public formBuilder: FormBuilder) { }

  ngOnInit() {

    this.formulario = this.formBuilder.group({
      apellidos: new FormControl('', Validators.compose([
        Validators.maxLength(50),
        Validators.pattern('^[a-zA-ZáéíóúÁÉÍÓÚ ]+$'),
        Validators.required
      ])),
      nombre: new FormControl('', Validators.compose([
        Validators.maxLength(30),
        Validators.pattern('^[a-zA-ZáéíóúÁÉÍÓÚ ]+$'),
        Validators.required
      ])),
      dniPasaporte: new FormControl('', Validators.required),
      dni: new FormControl('', Validators.compose([
        this.validDNI,
        Validators.maxLength(9),
        Validators.minLength(9),
        Validators.pattern('^([0-9]{8,8}[A-Za-z])?$'),
      ])),
      pasaporte: new FormControl('', Validators.pattern('^([0-9]{10,10})?$')),
      nacionalidad: new FormControl('', Validators.compose([
        Validators.maxLength(50),
        Validators.pattern('^([a-zA-ZÑñáéíóúÁÉÍÓÚ ]+)?$')
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

  onChangeDniPasaporte($event) {
    this.formulario.get('dni').setValue('');
    this.formulario.get('pasaporte').setValue('');
    this.formulario.get('nacionalidad').setValue('');
  }

  onSubmit(values) {
    let usuario: Usuario = new Usuario();
    usuario.dni = values['dni'];
    usuario.apellidos = values['apellidos'];
    usuario.nombre = values['nombre'];
    usuario.pasaporte = values['pasaporte'];
    usuario.nacionalidad = values['nacionalidad'];
    console.log(usuario);
  }

  formularioValido() {
    if (!this.formulario.valid)
      return false;
    if (this.formulario.valid && this.formulario.get('dni').value == '' && this.formulario.get('dniPasaporte').value == 'dni')
      return false;
    if (this.formulario.valid && this.formulario.get('pasaporte').value == '' && this.formulario.get('dniPasaporte').value == 'pasaporte')
      return false;
    if (this.formulario.valid && this.formulario.get('nacionalidad').value == '' && this.formulario.get('dniPasaporte').value == 'pasaporte')
      return false;
    return true;

  }

}//end_class
