import { Component } from '@angular/core';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  private grados:string[]=['ESO','Ciclo'];
  private esoG:string[]=[ '1º ESO', '2º ESO', '3º ESO', '4º ESO'];
  constructor(public alertController: AlertController) {this.alertgrado();}

    async alertgrado() {
      const alert = await this.alertController.create({
        header: "Elige grado",
        inputs: [
          {
            type: 'textarea',
            name: 'grados1',
            placeholder: this.grados[0],
          },
          {
            type: 'textarea',
            name: 'grados1',
            placeholder: this.grados[1],
          }
        ],
        buttons: [
          {
            text: 'Cancel',
            role: 'cancel',
            handler: () => {
             
            },
          },
          {
            text: 'OK',
            role: 'confirm',
            handler: (data) => {
              let grado1 =data.grados1;
              let grado2=data.grados2;
              let grado;
              if(grado1==''){
                grado=grado2;
                this.alerteso();
              }else{
                grado=grado1;
               
                this.alertfp();
              }
             
            },
          }
        ]
      });
  
      await alert.present();
    }

    async alertfp() {
      const alert = await this.alertController.create({
        header: "Elige módulo",
        inputs: [
          {
            type: 'textarea',
            name: 'grados1',
            placeholder: 'DAM',
          },
          {
            type: 'textarea',
            name: 'grados2',
            placeholder: 'DAW',
          },
          {
            type: 'textarea',
            name: 'grados3',
            placeholder: 'ASIR',
          }
        ],
        buttons: [
          {
            text: 'Cancel',
            role: 'cancel',
            handler: () => {
             
            },
          },
          {
            text: 'OK',
            role: 'confirm',
            handler: (data) => {
              let grado1 =data.grados1;
              let grado2=data.grados2;
              let grado3=data.grados3;
              let grado;
              if(grado1==''){
                grado=grado2;
              }else if(grado2==''){
                grado=grado1;
              }else{
                grado=grado3;
              }
             
            },
          }
        ]
      });
  
      await alert.present();
    }
    async alerteso() {
      const alert = await this.alertController.create({
        header: "Elige grado",
        inputs: [
          {
            type: 'textarea',
            name: 'Grados1',
            placeholder: this.esoG[0],
          },
          {
            type: 'textarea',
            name: 'Grados2',
            placeholder: this.esoG[1],
          },
          {
            type: 'textarea',
            name: 'Grados3',
            placeholder: this.esoG[2],
          },
          {
            type: 'textarea',
            name: 'Grados4',
            placeholder: this.esoG[3],
          }
        ],
        buttons: [
          {
            text: 'Cancel',
            role: 'cancel',
            handler: () => {
             
            },
          },
          {
            text: 'OK',
            role: 'confirm',
            handler: (data) => {
              let grado1 =data.grados1;
              let grado2=data.grado2;
              let grado3=data.grado3;
              let grado4=data.grado4;
              let grado;
              if(grado1==''){
                grado=grado2;  
              }else{
                grado=grado1;
              }
             
            },
          }
        ]
      });
  
      await alert.present();
    }
    
  }


