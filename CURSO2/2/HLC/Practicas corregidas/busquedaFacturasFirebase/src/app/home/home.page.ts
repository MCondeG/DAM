import { Component, OnInit } from '@angular/core';
import { ModalController, ToastController } from '@ionic/angular';
import { FireServiceProvider } from 'src/providers/api-service/fire-service';
import { BuscarFacturaPage } from '../buscar-factura/buscar-factura.page';
import { Factura } from '../modelo/Factura';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  private facturas = new Array<Factura>();

  //se inyectan los dos providers para poder cambiar entre firebase y json-server
  constructor(public firebaseService: FireServiceProvider,
    public modalController: ModalController,
    public toastController: ToastController) {
  }


  ngOnInit(): void {
    this.leerFacturas();
  }

  async buscar() {
    const modal = await this.modalController.create({
      component: BuscarFacturaPage,
      componentProps: {
      }
    });

    modal.onDidDismiss().then((dataFacturas) => {
      let facturas: Factura[] = dataFacturas['data'];
      if (facturas != null) {
        if (facturas.length == 0) {
          //no se ha encontrado ninguna factura que cumpla los criterios de búsqueda
          this.presentToast("No existen facturas con ese criterio de búsqueda");
          //vuelvo a leer todas las facturas
          this.leerFacturas();
        }
        else {
          //se han encontrado facturas que cumplen los criterios de búsqueda
          this.facturas = facturas;
        }
      }
      else {
        //se ha cancelado la búsqueda
        //vuelvo a leer todas las facturas
        this.leerFacturas();
      }
    });
    return await modal.present();
  }//end_modificarAlumno

  async presentToast(message: string) {
    const toast = await this.toastController.create({
      message: message,
      duration: 2000
    });
    toast.present();
  }

  leerFacturas(){
    this.firebaseService.getFacturas()
    .then((facturas: Factura[]) => {
      this.facturas = facturas;
    })
    .catch((error: string) => {
      console.log(error);
    });
  }


}//end_class