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

  constructor(public formBuilder: FormBuilder, private navCtrl: NavController) {

  }

  ngOnInit() {

    this.validations_form = this.formBuilder.group({
      dni: new FormControl('', Validators.compose([
        this.invalidDNI,
        Validators.minLength(9),
        Validators.maxLength(9),
        Validators.pattern('^[0-9]{8}[a-zA-Z]$'),
        Validators.required
      ])),
      iban: new FormControl('', Validators.compose([
        Validators.minLength(24),
        Validators.maxLength(24),
        Validators.pattern('^E{1}S{1}([0-9]{22})$'),
        Validators.required
      ])) 
    });
  }

  invalidDNI(fc: FormControl) {

    let num = parseInt(fc.value.substring(0, 8));

    let dni = {
      letra: fc.value.substring(8,9).toUpperCase(),
      cadena: ("TRWAGMYFPDXBNJZSQVHLCKET").substring(num % 23, (num % 23)+1)
    };

    if (dni.letra === dni.cadena) return (null);
    else return ({ invalidDNI: true });
  }

  onSubmit(values) {
    console.log(values);
    let navigationExtras: NavigationExtras = {
        queryParams: {
            user: JSON.stringify(values),
            numero: 3
        }
    };

    this.navCtrl.navigateForward('/user', navigationExtras);
  }
}