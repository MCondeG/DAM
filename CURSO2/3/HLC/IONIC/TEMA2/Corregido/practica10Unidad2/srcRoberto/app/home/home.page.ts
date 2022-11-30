import { Component } from '@angular/core';
import { AlertController } from '@ionic/angular';
import { ValueAccessor } from '@ionic/angular/directives/control-value-accessors/value-accessor';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  private sel: String;

  constructor(public alertController: AlertController) {
    this.seleccionCurso();
    if (this.sel == "eso") {
      this.seleccionESO();
    } else if (this.sel == "ciclo"){
      this.seleccionCiclo();
    }
  }

  async seleccionCurso() {
    const alert = await this.alertController.create({
      header: 'Elige tu curso',
      buttons: ['OK'],
      inputs: [
        {
          label: 'Eso',
          type: 'radio',
          value: 'eso',
          handler: (data) => { //takes the data 
            console.log(data.value);
            this.seleccionESO();
            this.sel = data.value;
          }
        },
        {
          label: 'Ciclo',
          type: 'radio',
          value: 'ciclo',
          handler: (data) => { //takes the data 
            console.log(data.value);
            this.seleccionCiclo();
            this.sel = data.value;
          }
        }
      ]
      
    });
    await alert.present();
  }

  async seleccionESO() {
    const alert = await this.alertController.create({
      header: 'Elige tu curso',
      buttons: ['OK'],
      inputs: [
        {
          label: '1º Eso',
          type: 'radio',
          value: '1eso',
          handler: (alertData) => { //takes the data 
            console.log(alertData.value);
            this.repetidor();
          }
        },
        {
          label: '2º Eso',
          type: 'radio',
          value: '2eso',
          handler: (alertData) => { //takes the data 
            console.log(alertData.value);
            this.repetidor();
          }
        },
        {
          label: '3º Eso',
          type: 'radio',
          value: '3eso',
          handler: (alertData) => { //takes the data 
            console.log(alertData.value);
            this.repetidor();
          }
        },
        {
          label: '4º Eso',
          type: 'radio',
          value: '4eso',
          handler: (alertData) => { //takes the data 
            console.log(alertData.value);
            this.repetidor();
          }
        },
      ],
    });
    await alert.present();

  }

  async seleccionCiclo() {
    const alert = await this.alertController.create({
      header: 'Elige tu curso',
      buttons: ['OK'],
      inputs: [
        {
          label: 'DAM',
          type: 'radio',
          value: 'dam',
        },
        {
          label: 'DAW',
          type: 'radio',
          value: 'daw',
        },
        {
          label: 'ASIR',
          type: 'radio',
          value: 'asir',
        }
      ],
    });

    await alert.present();
  }

  async repetidor() {
    const alert = await this.alertController.create({
      header: '¿Es repetidor?',
      buttons: ['OK'],
      inputs: [
        {
          label: 'SI',
          type: 'radio',
          value: 'repetidor',
        },
        {
          label: 'NO',
          type: 'radio',
          value: 'noRepetidor',
        }
      ],
    });

    await alert.present();
  }
}
