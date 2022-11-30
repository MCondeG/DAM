import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { NavigationExtras } from '@angular/router';
import { NavController } from '@ionic/angular';
import { User } from '../modelo/user';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  validations_form: FormGroup;
  sexos: Array<string>;
  estadosCivil: Array<string>;
  matching_passwords_group: FormGroup;

  validation_messages = {
    'nombre': [
      { type: 'required', message: 'nombre es requerido' }
    ],
    'apellidos': [
      { type: 'required', message: 'apellidos es requerido' }
    ],
    'edad': [
      { type: 'required', message: 'edad es requerido' }
    ],
    'dni': [
      { type: 'pattern', message: 'formato incorrecto' }
    ]
  };



  constructor(private fb: FormBuilder,
    private navCtrl: NavController) {
    this.validations_form = this.fb.group({
      nombre: new FormControl('', Validators.required),
      apellidos: new FormControl('', Validators.required),
      edad: new FormControl('', Validators.required),
      sexo: new FormControl('', Validators.required),
      dni: new FormControl('', Validators.pattern('(^\s*$)|(^[0-9]{8}[AaBbCcDdEe]{1}$)')),
      trabaja: new FormControl(false),
      estadoCivil: new FormControl(''),
      dniPadre: new FormControl(''),
      apellidosPadre: new FormControl(''),
      dniMadre: new FormControl(''),
      apellidosMadre: new FormControl('')
    }, { validators: [this.formularioNoValido()] });
  }

  ngOnInit(): void {

    this.sexos = [
      "Hombre",
      "Mujer"
    ];

    this.estadosCivil = [
      "Soltero",
      "Casado",
      "Viudo",
      "Divorciado"
    ];
  }

  formularioNoValido(): ValidatorFn {

    return (formGroup: FormGroup) => {
      const edad: number = Number(formGroup.get('edad').value);
      const dni: string = formGroup.get('dni').value;
      const estadoCivil: string = formGroup.get('estadoCivil').value;
      const dniPadre: string = formGroup.get('dniPadre').value;
      const apellidosPadre: string = formGroup.get('apellidosPadre').value;
      const dniMadre: string = formGroup.get('dniMadre').value;
      const apellidosMadre: string = formGroup.get('apellidosMadre').value;


      if (edad >= 18) {
        if (!dni || !estadoCivil)
          return { isValid: false };
      }
      if (edad < 18) {
        if (!dniPadre || !dniMadre || !apellidosPadre || !apellidosMadre)
          return { isValid: false };
      }
      //en otro caso se valida
      return null;
    };
  }

  cambiaEdad() {
    this.validations_form.controls['dniPadre'].setValue(null);
    this.validations_form.controls['dniMadre'].setValue(null);
    this.validations_form.controls['apellidosPadre'].setValue(null);
    this.validations_form.controls['apellidosMadre'].setValue(null);
    this.validations_form.controls['dni'].setValue(null);
    this.validations_form.controls['trabaja'].setValue(null);
    this.validations_form.controls['estadoCivil'].setValue(null);
  }

  getIntEdad() {
    return (Number(this.validations_form.get('edad').value));
  }

  onSubmit(values) {

    console.log(values);
    let user: User = new User(values.username,
      values.name, values.lastname, values.email, values.gender, values.terms);
    let navigationExtras: NavigationExtras = {
      queryParams: {
        user: JSON.stringify(user),
        numero: 3
      }
    };
    this.navCtrl.navigateForward('/user', navigationExtras);
  }//end_onSubmit



}//end_class
