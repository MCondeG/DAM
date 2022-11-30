import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
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
  genders: Array<string>;
  matching_passwords_group: FormGroup;

  validation_messages = {
    'username': [
      { type: 'required', message: 'Username is required.' },
      { type: 'minlength', message: 'Username must be at least 5 characters long.' },
      { type: 'maxlength', message: 'Username cannot be more than 25 characters long.' },
      { type: 'pattern', message: 'Your username must contain only numbers and letters, and must begin with a letter.' },
      { type: 'validUsername', message: 'Your username has already been taken.' }
    ],
    'name': [
      { type: 'required', message: 'Name is required.' }
    ],
    'lastname': [
      { type: 'required', message: 'Last name is required.' }
    ],
    'email': [
      { type: 'required', message: 'Email is required.' },
      { type: 'pattern', message: 'Please enter a valid email.' }
    ],
    'password': [
      { type: 'required', message: 'Password is required.' },
      { type: 'minlength', message: 'Password must be at least 8 characters long.' },
      { type: 'maxlength', message: 'Password must be less than or equal to 15 characters.' },
      { type: 'pattern', message: 'Your password must contain at least one uppercase, one lowercase, one number and one of this characters: . - ;' }
    ],
    'confirmPassword': [
      { type: 'required', message: 'Confirm password is required.' }
    ],
    'matching_passwords': [
      { type: 'passwordRepetida', message: 'Password mismatch.' }
    ],
    'terms': [
      { type: 'pattern', message: 'You must accept terms and conditions.' }
    ],
  };

  constructor(public formBuilder: FormBuilder,
    private navCtrl: NavController) {


  }

  ngOnInit(): void {

    this.genders = [
      "Male",
      "Female"
    ];

    this.matching_passwords_group = new FormGroup({
      password: new FormControl('', Validators.compose([
        Validators.maxLength(15),
        Validators.minLength(8),
        Validators.pattern('^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[.,-]).*$'),
        Validators.required
      ])),
      confirmPassword: new FormControl('', Validators.required)
    }, (formGroup: FormGroup) => {
      return this.passwordRepetida(formGroup);
    });

    this.validations_form = this.formBuilder.group({
      username: new FormControl('', Validators.compose([
        this.userNameRepetido,
        Validators.maxLength(25),
        Validators.minLength(5),
        Validators.pattern('^[a-zA-Z]{1}[a-zA-Z0-9]+$'),
        Validators.required
      ])),
      name: new FormControl('', Validators.required),
      lastname: new FormControl('', Validators.required),
      email: new FormControl('pedroblanch@gmail.com', Validators.compose([
        Validators.required,
        Validators.pattern('^[a-zA-Z0-9_.+-]+[@]{1}[a-zA-Z0-9-]+[.]{1}[a-zA-Z]+$')
      ])),
      gender: new FormControl(this.genders[0], Validators.required),
      terms: new FormControl(false, Validators.pattern('true')),
      matching_passwords: this.matching_passwords_group
    });
  }//end_ngOnInit

  passwordRepetida(fg: FormGroup) {
    if (fg.controls['password'].value != fg.controls['confirmPassword'].value)
      return ({ passwordRepetida: true });  //no se valida
    else
      return (null);  //si se valida
  }

  userNameRepetido(fc: FormControl) {
    if (fc.value.toLowerCase() === "abc123" || fc.value.toLowerCase() === "cba321") {
      return ({ userNameRepetido: true });  //no se valida
    } else {
      return (null);  //se valida
    }
  }


  onSubmit(values) {
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
