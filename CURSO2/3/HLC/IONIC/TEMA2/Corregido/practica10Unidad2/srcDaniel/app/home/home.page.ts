import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  cursoEso: String = "";
  cursoCiclos: String = "";
  ciclos: Boolean = false;
  resultList: String;
  tiposCiclos: String[] = ["DAM", "DAW", "ASIR"];

  constructor(public alertController: AlertController) {
    this.tipo();
  }

  async tipo() {
    const alert = await this.alertController.create({
      header: "Seleccione",
      inputs: [
        {
          label: 'ESO',
          type: 'radio',
          value: 'ESO - ',
          name: 'tipo',
        },
        {
          label: 'Ciclos',
          type: 'radio',
          value: 'Ciclos - ',
          name: 'tipo',
        },
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
            if (data['tipo'] == 'ESO - ') { 
              let eso = String(data['tipo']);
              this.cursoEso = eso;
              this.eso();
            } else if (data['tipo'] == 'Ciclos - '){
              this.cursoCiclos = String(data['tipo']);
              this.ciclos = true;
            }
          },
        }
      ]
    });
    await alert.present();
  }

  async eso() {
    const alert2 = await this.alertController.create({
      header: "Seleccione",
      inputs: [
        {
          label: '1ESO',
          type: 'radio',
          value: '1ESO - ',
          name: 'curso',
        },
        {
          label: '2ESO',
          type: 'radio',
          value: '2ESO - ',
          name: 'curso',
        },
        {
          label: '3ESO',
          type: 'radio',
          value: '3ESO - ',
          name: 'curso',
        },
        {
          label: '4ESO',
          type: 'radio',
          value: '4ESO - ',
          name: 'curso',
        },
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
            let datosCurso = String(data['tipo']);
            this.cursoEso = this.cursoEso + datosCurso;
            console.log(this.cursoEso);
            this.repite();
          },
        }
      ]
    });
    await alert2.present();
  }

  async repite() {
    const alert3 = await this.alertController.create({
      header: "Repite?",
      inputs: [
        {
          label: 'Sí',
          type: 'radio',
          value: 'repite',
          name: 'repite',
        },
        {
          label: 'No',
          type: 'radio',
          value: 'no repite',
          name: 'repite',
        },
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
            let datos =  String(data['repite']);
            this.cursoEso = this.cursoEso + datos;
            console.log(this.cursoEso);
          },
        }
      ]
    });
    await alert3.present();
  }

  cicloElegido() {
    this.cursoCiclos = this.cursoCiclos + '' +this.resultList;
    console.log(this.cursoCiclos);
  }

  
}
