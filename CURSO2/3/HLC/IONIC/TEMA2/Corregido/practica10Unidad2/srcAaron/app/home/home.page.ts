import { Component } from '@angular/core';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  claseSeleccionada:string;
  grupoEso:string;
  repitiendo:string;
  constructor(private alertController: AlertController) {}

  async escogerTipo() {
    const alert = await this.alertController.create({
      header: 'Select your favorite color',
      buttons: ['OK'],
      inputs: [
        {
          label: 'Eso',
          type: 'radio',
          value: 'Eso',
          handler: () => {
            this.claseSeleccionada = 'eso';
          },
          
        },
        {
          label: 'Ciclo',
          type: 'radio',
          value: 'Ciclo',
          handler: () => {
            this.claseSeleccionada = 'ciclo';
          },
        },
        
      ],
    });
    await alert.present();
  }
  async Eso() {
    const alert = await this.alertController.create({
      header: 'Select your favorite color',
      buttons: ['OK'],
      inputs: [
        {
          label: '1º eso',
          type: 'radio',
          value: '1eso',
          handler: () => {
            this.grupoEso = '1eso';
          },
        },
        {
          label: '2º eso',
          type: 'radio',
          value: '2eso',
          handler: () => {
            this.grupoEso = '2eso';
          },
        },
        {
          label: '3º eso',
          type: 'radio',
          value: '3eso',
          handler: () => {
            this.grupoEso = '3eso';
          },
        },
        {
          label: '4º eso',
          type: 'radio',
          value: '4eso',
          handler: () => {
            this.grupoEso = '4eso';
          },
        },
      ],
    });
    await alert.present();
  }
  async repite() {
    const alert = await this.alertController.create({
      header: 'Select your favorite color',
      buttons: ['OK'],
      inputs: [
        {
          label: 'Repite',
          type: 'radio',
          value: 'Repite',
          handler: () => {
            this.repitiendo = 'Repite';
          },
          
        },
        {
          label: 'No repite',
          type: 'radio',
          value: 'noRepite',
          handler: () => {
            this.repitiendo = 'No repite';
          },
        },
      ],
    });
    await alert.present();
  }

  comprobarEso(){
    console.log(this.claseSeleccionada +' '+this.grupoEso+' '+this.repitiendo );
  }

}
