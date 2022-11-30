import { Component, OnInit } from '@angular/core';
import { NavigationExtras } from '@angular/router';
import { NavController, ViewWillEnter } from '@ionic/angular';
import { Alumno } from '../modelo/Alumno';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit, ViewWillEnter {

  constructor(public navCtrl: NavController) {
    console.log('constructor home');
  }

  ionViewWillEnter(): void {
    console.log('ionViewWillEnter home');
  }

  ionViewDidEnter() {
    console.log('ionViewDidEnter home');
  }

  ionViewWillLeave(): void {
    console.log('ionViewWillLeave home');
  }

  ionViewDidLeave() {
    console.log('ionViewDidLeave home');
  }

  ngOnInit(): void {
    console.log('ngOnInit home');
  }

  goToPagina2() {
    let alumno: Alumno = new Alumno('27309418E', 'Ana', 'García Pérez');
    let navigationExtras: NavigationExtras = {
      queryParams: {
        alumno: JSON.stringify(alumno)
      }

    };
    this.navCtrl.navigateForward('/pagina2',navigationExtras);
  }

}
