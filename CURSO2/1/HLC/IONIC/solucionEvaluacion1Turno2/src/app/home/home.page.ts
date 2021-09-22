import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { NavigationExtras } from '@angular/router';
import { NavController } from '@ionic/angular';
import { Usuario } from '../modelo/Usuario';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})

export class HomePage implements OnInit {

  formulario: FormGroup;
  grupoUsuarioPassword: FormGroup;
  usuario:Usuario;

  usuarios= [
    {
      "id": 1,
      "usuario": "pedro",
      "password": "1234"
    },
    {
      "id": 2,
      "usuario": "marta",
      "password": "5678"
    }
  ];

  validation_messages = {
    'usuario': [
      { type: 'required', message: 'Usuario is required.' },
      { type: 'minlength', message: 'Usuario debe tener 5 caracteres como mínimo' },
      { type: 'maxlength', message: 'Usuario debe tener 10 caracteres como máximo' },
      { type: 'pattern', message: 'Usuario debe contener solo letras en minúscula o números' }
    ],
    'password': [
      { type: 'required', message: 'Password is required.' },
      { type: 'minlength', message: 'Password debe tener 3 caracteres como mínimo' },
      { type: 'maxlength', message: 'Password debe tener 10 caracteres como máximo' },
      { type: 'pattern', message: 'Password debe contener solo letras en maýusculas o minúsculas, o números' }
    ],
    'grupoUsuarioPassword': [
      { type: 'validarUsuarioPassword', message: 'Usuario y/o password incorrecta' }
    ]
  };

  constructor(public formBuilder: FormBuilder,
    private navCtrl: NavController) {
      this.grupoUsuarioPassword = new FormGroup({
        usuario: new FormControl('', Validators.compose([
          Validators.required,
          Validators.pattern('^[a-z0-9]+$'),
          Validators.maxLength(10),
          Validators.minLength(5)
        ])),
        password: new FormControl('', Validators.compose([
          Validators.required,
          Validators.pattern('^[a-zA-Z0-9]+$'),
          Validators.maxLength(10),
          Validators.minLength(3)
        ]))
      }, (formGroup: FormGroup) => {
        return this.validarUsuarioPassword(formGroup);
      });
    
      this.formulario = this.formBuilder.group({
        grupoUsuarioPassword: this.grupoUsuarioPassword
      });
    }

  ngOnInit() {
  }

  onSubmit(values){    
    let navigationExtras: NavigationExtras = {
      queryParams: {
          usuario: JSON.stringify(this.usuario)
      }
    };
    this.navCtrl.navigateForward('/reservas-usuario', navigationExtras);
  }

  validarUsuarioPassword(fg: FormGroup){
    var usuario:string=fg.controls['usuario'].value;
    var password:string=fg.controls['password'].value;
    var correcto=false;
    //se busca el usuario en el array
    this.usuarios.forEach(objetoUsuario => {
      if(objetoUsuario.usuario==usuario){
        if(objetoUsuario.password==password){
            this.usuario=new Usuario(objetoUsuario.id, usuario, password);
            correcto=true;
        }
        else{  //si la clave no soincide no se valida
            correcto=false;
        }
      }
    });  //end forEach
    //si no se encuentra el usuario no se valida
    if(correcto)
      return null;
    else
      return {validarUsuarioPassword:true}
  }//end validarUsuarioPassword

}//end class
