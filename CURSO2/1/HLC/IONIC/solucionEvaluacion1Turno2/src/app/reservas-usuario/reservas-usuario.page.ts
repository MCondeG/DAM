import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Usuario } from '../modelo/Usuario';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-reservas-usuario',
  templateUrl: './reservas-usuario.page.html',
  styleUrls: ['./reservas-usuario.page.scss'],
})

export class ReservasUsuarioPage implements OnInit {

  usuario:Usuario;

  reservas= [
    {
      "id": 1,
      "idUsuario": "1",
      "alojamiento": "Plaza mayor de lujo",
      "localidad": "Madrid",
      "pais": "España",
      "fechaEntrada": "2019-12-16",
      "fechaSalida": "2019-12-18",
      "horaEntrada": "15:00",
      "horaSalida": "11:00",
      "precio": 290,
      "valoracion": 3
    },
    {
      "id": 2,
      "idUsuario": "1",
      "alojamiento": "Weekendo",
      "localidad": "Granada",
      "pais": "España",
      "fechaEntrada": "2020-01-18",
      "fechaSalida": "2020-05-19",
      "horaEntrada": "15:00",
      "horaSalida": "11:30",
      "precio": 159,
      "valoracion": 4
    },
    {
      "id": 3,
      "idUsuario": "2",
      "alojamiento": "Apartamentos Casa Isabale",
      "localidad": "Biescas",
      "pais": "España",
      "fechaEntrada": "2020-02-21",
      "fechaSalida": "2020-02-22",
      "horaEntrada": "14:30",
      "horaSalida": "11:30",
      "precio": 123,
      "valoracion": 2
    },
    {
      "id": 4,
      "idUsuario": "1",
      "alojamiento": "Hotel YIT Ciudad De Zaragoza",
      "localidad": "Zaragoza",
      "pais": "España",
      "fechaEntrada": "2020-03-18",
      "fechaSalida": "2020-03-19",
      "horaEntrada": "13:00",
      "horaSalida": "12:00",
      "precio": 55,
      "valoracion": 3
    }
  ];

  constructor(private activatedRoute: ActivatedRoute, public alertCtrl: AlertController) { 
    this.activatedRoute.queryParams.subscribe(params => {
      this.usuario = JSON.parse(params['usuario']);
    });
  }

  ngOnInit() {
  }

  async cancelarReserva(alojamiento:string, indice:number) {
    const alert = await this.alertCtrl.create({
      header: 'Confirm!',
      message: '<strong>¿Cancelar reserva en '+alojamiento+'?</strong>',  //se puede combinar con etiquetas html
      buttons: [
        {
          text: 'No',
          role: 'cancel',
          cssClass: 'secondary',   //se le puede especificar una clase css de librería o personal
          handler: () => {
          }
        }, {
          text: 'Si',
          handler: () => {
            if(indice > -1){
                this.reservas.splice(indice, 1);  //elimina 1 elemento del array a partir de index
            }
          }
        }
      ]
    });
    await alert.present();
  }
}
