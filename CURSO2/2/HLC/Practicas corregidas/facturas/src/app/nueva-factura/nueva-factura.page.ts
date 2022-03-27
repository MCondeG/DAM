import { Component, OnInit } from '@angular/core';
import { AlertController, ModalController, NavController } from '@ionic/angular';
import { ApiServiceProvider } from 'src/providers/api-service/api-service';
import { AddProductoPage } from '../add-producto/add-producto.page';
import { Cliente } from '../modelo/Cliente';
import { DetalleProducto } from '../modelo/DetalleProducto';
import { Factura } from '../modelo/Factura';

@Component({
  selector: 'app-nueva-factura',
  templateUrl: './nueva-factura.page.html',
  styleUrls: ['./nueva-factura.page.scss'],
})
export class NuevaFacturaPage implements OnInit {

  clientes: Cliente[] = new Array();
  factura: Factura = new Factura();
  clienteSeleccionado: Cliente = null;

  constructor(private apiService: ApiServiceProvider,
    private modalController: ModalController,
    private alertController: AlertController,
    private navCtrl: NavController) {
  }

  ngOnInit(): void {
    this.apiService.getClientes()
      .then((clientes: Cliente[]) => {
        this.clientes = clientes;
      })
      .catch((error: string) => {
        console.log(error);
      });
  }

  validarSubmit(): boolean {
    if (this.factura.cliente == null)
      return false;
    if (this.factura.productos.length == 0)
      return false;
    if (this.factura.porcentajeIva == null)
      return false;
    if (this.factura.porcentajeIva < 0)
      return false;
    return true;
  }

  eliminarProducto(indice: number) {
    this.factura.productos.splice(indice, 1);
  }

  seleccionadoCliente() {
    this.factura.cliente = this.clienteSeleccionado.cliente;
  }

  addUnidadProducto(indice: number) {
    this.factura.productos[indice].unidades++;
  }

  quitarUnidadProducto(indice: number) {
    if (this.factura.productos[indice].unidades > 1)
      this.factura.productos[indice].unidades--;
  }

  async addProducto() {
    const modal = await this.modalController.create({
      component: AddProductoPage,
      componentProps: {
      }
    });

    modal.onDidDismiss().then((data) => {
      if (data['data'] != null) {
        let detalleProductoJSON = JSON.parse(data['data']);
        let detalleProducto: DetalleProducto = DetalleProducto.createFromJsonObject(detalleProductoJSON);
        this.factura.productos.push(detalleProducto);
      }

    });
    return await modal.present();
  }//end_addProducto

  async submit() {
    const alert = await this.alertController.create({
      cssClass: 'my-custom-class',
      header: '¿Grabar factura?',
      message: '',
      buttons: [
        {
          text: 'No',
          role: 'cancel',
          cssClass: 'secondary',
          id: 'cancel-button',
          handler: (blah) => {
            console.log('Confirm Cancel: blah');
          }
        }, {
          text: 'Si',
          id: 'confirm-button',
          handler: () => {
            this.apiService.insertarFactura(this.factura)
              .then((factura: Factura) => {
                this.navCtrl.navigateRoot('/home');
              })
              .catch((error: string) => {
                console.log(error);
              });
          }
        }
      ]
    });
    await alert.present();
  }//end_submit

  async cancel() {
    const alert = await this.alertController.create({
      cssClass: 'my-custom-class',
      header: '¿Cancelar?',
      message: '',
      buttons: [
        {
          text: 'No',
          role: 'cancel',
          cssClass: 'secondary',
          id: 'cancel-button',
          handler: (blah) => {
            console.log('Confirm Cancel: blah');
          }
        }, {
          text: 'Si',
          id: 'confirm-button',
          handler: () => {
            this.navCtrl.navigateRoot('/home');
          }
        }
      ]
    });
    await alert.present();
  }//end_cancel

}//end_class
