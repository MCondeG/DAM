import { Component, OnInit } from '@angular/core';
import { ToastController } from '@ionic/angular';
import { FireServiceProvider } from 'src/providers/api-service/fire-service';
import { Reserva } from '../modelo/Reserva';

@Component({
  selector: 'app-buscar-reservas',
  templateUrl: './buscar-reservas.page.html',
  styleUrls: ['./buscar-reservas.page.scss'],
})
export class BuscarReservasPage implements OnInit {

  fecha: string;
  reservas: Reserva[] = new Array<Reserva>();

  constructor(public firebaseService: FireServiceProvider,
    public toastController: ToastController) {
  }

  ngOnInit() {
  }

  buscarReservas() {
    console.log(this.fecha);
    this.firebaseService.getReservas(this.fecha)
      .then((reservas: Reserva[]) => {
        this.reservas = reservas;
      })
      .catch((error: string) => {
        console.log(error);
      });
  }

}
