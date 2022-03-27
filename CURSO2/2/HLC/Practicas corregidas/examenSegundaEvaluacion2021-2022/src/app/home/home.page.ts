import { Component, OnInit } from '@angular/core';
import { ModalController, NavController, ToastController } from '@ionic/angular';
import { ApiServiceProvider } from 'src/providers/api-service/api-service';
import { FireServiceProvider } from 'src/providers/api-service/fire-service';
import { NuevaReservaPage } from '../nueva-reserva/nueva-reserva.page';
import { Hotel } from '../modelo/Hotel';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  private hoteles = new Array<Hotel>();

  //se inyectan los dos providers para poder cambiar entre firebase y json-server
  constructor(private apiService: ApiServiceProvider,
    public firebaseService: FireServiceProvider,
    public modalController: ModalController,
    public toastController: ToastController,
    public navCtrl: NavController) {
  }

  ngOnInit(): void {
    this.apiService.getHoteles()
      .then((hoteles: Hotel[]) => {
        this.hoteles = hoteles;
      })
      .catch((error: string) => {
        console.log(error);
      });
  }


  async nuevaReserva(indice: number) {
    const modal = await this.modalController.create({
      component: NuevaReservaPage,
      componentProps: {
        'hotelJson': JSON.stringify(this.hoteles[indice])
      }
    });

    modal.onDidDismiss().then(() => {
      //no se hace nada
    });

    return await modal.present();

  }//end_nuevaReserva



  async presentToast(message: string) {
    const toast = await this.toastController.create({
      message: message,
      duration: 2000
    });
    toast.present();
  }

  buscarReservas(){
    this.navCtrl.navigateForward('/buscar-reservas');
  }

}//end_class