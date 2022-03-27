import { Component, OnInit } from '@angular/core';
import { AlertController, ModalController, ToastController } from '@ionic/angular';
import { FireServiceProvider } from 'src/providers/api-service/fire-service';
import { Factura } from '../modelo/Factura';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  private facturas = new Array<Factura>();
  private numeroElementosPorPagina = 5;

  //se inyectan los dos providers para poder cambiar entre firebase y json-server
  constructor(public firebaseService: FireServiceProvider,
    public modalController: ModalController,
    public toastController: ToastController,
    public alertController: AlertController) {
  }


  ngOnInit(): void {
    this.leerFacturas(FireServiceProvider.INICIO);
  }

  siguiente() {
    this.leerFacturas(FireServiceProvider.SIGUIENTE);
  }

  anterior() {
    this.leerFacturas(FireServiceProvider.ANTERIOR);
  }

  inicio() {
    this.leerFacturas(FireServiceProvider.INICIO);
  }

  ultimo() {
    this.leerFacturas(FireServiceProvider.ULTIMO);
  }

  leerFacturas(accion: number) {
    this.firebaseService.getFacturas(this.numeroElementosPorPagina, accion)
      .then((facturas: Factura[]) => {
        this.facturas = facturas;
      })
      .catch((error: string) => {
        console.log(error);
      });
  }

  async settings() {
    const alert = await this.alertController.create({
      header: 'settings',
      inputs: [
        {
          name: 'numeroElementosPorPagina',
          value: this.numeroElementosPorPagina,
          type: 'number',
          min: 1,
          max: 20,
          placeholder: 'elementos por página'
        }
      ],
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          handler: () => {
            console.log('Confirm Cancel');
          }
        }, {
          text: 'Ok',
          handler: (data:any) => {
            this.numeroElementosPorPagina=data['numeroElementosPorPagina'];
          }
        }
      ]
    });
    await alert.present();
  }//end_settings


}//end_class