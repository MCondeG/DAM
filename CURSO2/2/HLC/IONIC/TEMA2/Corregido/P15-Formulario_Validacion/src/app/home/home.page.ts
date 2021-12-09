import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { NavigationExtras } from '@angular/router';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  validations_form: FormGroup;
  cuenta: FormGroup;
  validation_messages = {
    'DNI': [
      { type: 'validDNI', message: 'La letra no corresponde con los números' },
      { type: 'required', message: 'DNI es requerido' },
      { type: 'minlength', message: 'DNI debe tener 9 caracteres' },
      { type: 'maxlength', message: 'DNI debe tener 9 caracteres' },
      { type: 'pattern', message: 'DNI debe tener el patrón correspondiente' },
    ],
    'IBAN': [
      { type: 'required', message: 'IBAN es requerido' },
      { type: 'minlength', message: 'IBAN debe tener 24 caracteres' },
      { type: 'maxlength', message: 'IBAN debe tener 24 caracteres' },
      { type: 'pattern', message: 'Introduce un IBAN válido' }
    ],
    'cuenta': [
      { type: 'validIBAN', message: 'El DNI no tiene asociado este IBAN' }
    ]
  };
  
  //los dni son ficticios. Se han obtenido en esta web:  https://generadordni.es/#dni
  arrayDniCuenta = {
    '65508205L':'ES1234567890123456789012',
    '12979007S':'ES1234567890123456789013',
    '52045931J':'ES1234567890123456789014',
};



  constructor(
    public formBuilder: FormBuilder,
    private navCtrl: NavController
  ) { }

  ngOnInit() {


    this.cuenta = new FormGroup({
      DNI: new FormControl('', Validators.compose([
        this.validDNI,
        Validators.maxLength(9),
        Validators.minLength(9),
        Validators.pattern('[0-9]{8,8}[A-Za-z]'),
        Validators.required
      ])),
      IBAN: new FormControl('', Validators.compose([
        Validators.maxLength(24),
        Validators.minLength(24),
        Validators.pattern('ES[0-9]{22}'),
        Validators.required,
      ]))
    }, (formGroup: FormGroup) => {
      return this.validIBAN(formGroup);
    });

    this.validations_form = this.formBuilder.group({
      cuenta: this.cuenta,
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

  validIBAN(fg: FormGroup) {
    var iban = fg.controls['IBAN'].value
    var dni = fg.controls['DNI'].value
    //se recorre el array asociativo que relaciona dnis con ibans
    //si encuentra que la clave (dni) es igual a la introducida
    //y que el iban asociado a dicha clave es igual al introducido
    //devuelve null y la validación es correcta
    //si se sale del array significa que no lo ha encontrado
    //devuelve true y la validación es no incorrecta
    for (var clave in this.arrayDniCuenta){
        console.log(clave);
        console.log(this.arrayDniCuenta[clave]);
        if(clave==dni && this.arrayDniCuenta[clave]==iban)  //encontrado
          return null;
    }
    return ({ validIBAN: true });
  }

}//end_class
