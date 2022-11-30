import { Component } from '@angular/core';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  private cursoESO: string;
  private escogidoCiclo: boolean=false;
  private ciclos:string[]=['DAM', 'DAW', 'ASIR'];
  private cicloSeleccionado:string;

  constructor(public alertController: AlertController) {
    this.alertCicloEso();
  }

  async alertCicloEso() {
    const alert = await this.alertController.create({
      header: 'Escoja una opción:',
      inputs: [
        {
          name: 'eso',
          label: 'ESO',
          type: 'radio',
          value: 'eso'
        },
        {
          name: 'ciclo',
          label: 'CICLO',
          type: 'radio',
          value: 'ciclo'
        }
      ],
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          handler: () => {
          }
        },
        {
          text: 'OK',
          role: 'confirm',
          handler: (data) => {
            if (data == 'eso') {
              this.alertEscogerCursoESO();
            }
            if (data == 'ciclo') {
              this.escogidoCiclo=true;
            }
          }
        }
      ]
    });
    await alert.present();
  }//end_alertCicloEso

  async alertEscogerCursoESO() {
    const alert = await this.alertController.create({
      header: 'Escoja una opción:',
      inputs: [
        {
          name: '1eso',
          label: '1º ESO',
          type: 'radio',
          value: '1º ESO'
        },
        {
          name: '2eso',
          label: '2º ESO',
          type: 'radio',
          value: '2º ESO'
        },
        {
          name: '3eso',
          label: '3º ESO',
          type: 'radio',
          value: '3º ESO'
        },
        {
          name: '4eso',
          label: '4º ESO',
          type: 'radio',
          value: '4º ESO'
        }
      ],
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          handler: () => {
          }
        },
        {
          text: 'OK',
          role: 'confirm',
          handler: (data) => {
            if (data) {
              this.cursoESO = data;
              this.alertRepite();
            }
          }
        }
      ]
    });
    await alert.present();
  }//end_alertCicloEso

  async alertRepite() {
    const alert = await this.alertController.create({
      header: 'Indique si repite o no',
      inputs: [
        {
          name: 'repite',
          label: 'REPITE',
          type: 'radio',
          value: 'repite'
        },
        {
          name: 'noRepite',
          label: 'NO REPITE',
          type: 'radio',
          value: 'no repite'
        }
      ],
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          handler: () => {
          }
        },
        {
          text: 'OK',
          role: 'confirm',
          handler: (data) => {
            if(!data){
              return;
            }
            let cadena="ESO - " + this.cursoESO + " - " + data;
            console.log(cadena);
          }
        }
      ]
    });
    await alert.present();
  }//end_alertRepite

  seEscogeCiclo(event){
    console.log('CICLO - '+this.cicloSeleccionado)
  }

}//end_class
