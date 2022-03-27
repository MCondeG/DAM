import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { FireServiceProvider } from 'src/providers/api-service/fire-service';
import { Factura } from '../modelo/Factura';

@Component({
  selector: 'app-buscar-factura',
  templateUrl: './buscar-factura.page.html',
  styleUrls: ['./buscar-factura.page.scss'],
})
export class BuscarFacturaPage implements OnInit {

  private cliente: string = null;

  constructor(public modalCtrl: ModalController,
    public firebaseService: FireServiceProvider) {
  }

  ngOnInit() {
  }

  public closeModal() {
    this.modalCtrl.dismiss();  //se cancela la edición. No se devuelven datos.
  }

  buscar() {
    this.firebaseService.getFacturasPorCliente(this.cliente)
      .then((facturas: Factura[]) => {
        this.modalCtrl.dismiss(facturas);
      })
      .catch((error: string) => {
        console.log(error);
        this.modalCtrl.dismiss();
      });
  }

  habilitarBotonBusqueda() {
    if (this.cliente && this.cliente.trim() != ""){
      //el cliente no es nulo y tampoco está vacío
      return true;
    }
    return false;
  }

}//end_class
