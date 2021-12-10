import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { NavigationExtras } from '@angular/router';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-ejercicio1',
  templateUrl: './ejercicio1.page.html',
  styleUrls: ['./ejercicio1.page.scss'],
})
export class Ejercicio1Page implements OnInit {

  public validation: FormGroup;
  documento: string = "";

  constructor(public formBuilder: FormBuilder, private navCtrl: NavController) {

  }

  ngOnInit() {

    this.validation = this.formBuilder.group({
      nombre: new FormControl('', Validators.compose([
        Validators.maxLength(30),
        Validators.minLength(1),
        Validators.pattern('^[a-zA-Z]{1}[a-zA-Z0-9]+$'),
        Validators.required
      ])),
      apellido: new FormControl('', Validators.compose([
        Validators.maxLength(50),
        Validators.minLength(1),
        Validators.pattern('^[a-zA-Z]{1}[a-zA-Z0-9]+$'),
        Validators.required
      ])),
      dni: new FormControl('', Validators.compose([
        Validators.maxLength(50),
        Validators.minLength(1),
        Validators.pattern('^[a-zA-Z]{1}[a-zA-Z0-9]+$'),
        Validators.required
      ])),
      pasaporte: new FormControl('', Validators.compose([
        Validators.maxLength(50),
        Validators.minLength(1),
        Validators.pattern('^[a-zA-Z]{1}[a-zA-Z0-9]+$'),
        Validators.required
      ])),
      nacionalidad: new FormControl('', Validators.compose([
        Validators.maxLength(50),
        Validators.minLength(1),
        Validators.pattern('^[a-zA-Z]{1}[a-zA-Z0-9]+$'),
        Validators.required
      ]))
    });
  }

  onSubmit(values) {
    let navigationExtras: NavigationExtras = {
      queryParams: {
        user: JSON.stringify(values),
      }
    };
    this.navCtrl.navigateForward('/usuario', navigationExtras);
  }
}