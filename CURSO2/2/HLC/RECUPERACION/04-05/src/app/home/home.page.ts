import { Component, OnInit } from '@angular/core';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  

  constructor(public alertCtrl: AlertController) {}
  
  
  ngOnInit(): void {
    
    this.curso();
  }



  async curso() {

    let esoChecked: boolean;

    let alert = await this.alertCtrl.create({
      header: '',
      backdropDismiss: false,
      inputs: [
        {
          name: 'radio1',
          type: 'radio',
          label: 'ESO',
          value: 'value1',
          handler: () => {
            console.log('Radio 1 selected');
            esoChecked = true;
          },
        },
        {
          name: 'radio2',
          type: 'radio',
          label: 'Bachillerato',
          value: 'value2',
          handler: () => {
            console.log('Radio 2 selected');
            esoChecked = false;
          }
        }],
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          handler: () => {
          }
        },
        {
          text: 'OK',
          handler: data => {
            if (esoChecked) {
              this.eso();
            }
            else {
              this.bachillerato();
            }
            return true;
          }
        }
      ]
    });
    alert.present();

    await alert.present();
  }

  async eso() {

    let esoCurso: number;

    let alert = await this.alertCtrl.create({
      header: '',
      backdropDismiss: false,
      inputs: [
        {
          name: 'radio1',
          type: 'radio',
          label: '1',
          value: 'value1',
          handler: () => {
            console.log('Radio 1 selected');
            esoCurso = 1;
          },
        },
        {
          name: 'radio2',
          type: 'radio',
          label: '2',
          value: 'value2',
          handler: () => {
            console.log('Radio 2 selected');
            esoCurso = 2;
          }
        },
        {
          name: 'radio1',
          type: 'radio',
          label: '3',
          value: 'value3',
          handler: () => {
            console.log('Radio 3 selected');
            esoCurso = 3;
          },
        },
        {
          name: 'radio2',
          type: 'radio',
          label: '4',
          value: 'value4',
          handler: () => {
            console.log('Radio 4 selected');
            esoCurso = 4;
          }
        }],
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          handler: () => {
          }
        },
        {
          text: 'OK',
          handler: data => {
            console.log(esoCurso.toString() + " ESO")
            return true;
          }
        }
      ]
    });
    alert.present();

    await alert.present();
  }

  async bachillerato() {

    let bachilleratoCurso: number;

    let alert = await this.alertCtrl.create({
      header: '',
      backdropDismiss: false,
      inputs: [
        {
          name: 'radio1',
          type: 'radio',
          label: '1',
          value: 'value1',
          handler: () => {
            console.log('Radio 1 selected');
            bachilleratoCurso = 1;
          },
        },
        {
          name: 'radio2',
          type: 'radio',
          label: '2',
          value: 'value2',
          handler: () => {
            console.log('Radio 2 selected');
            bachilleratoCurso = 2;
          }
        }],
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          handler: () => {
          }
        },
        {
          text: 'OK',
          handler: data => {
            console.log(bachilleratoCurso.toString() + " Bachillerato")
            return true;
          }
        }
      ]
    });
    alert.present();

    await alert.present();
  }
}