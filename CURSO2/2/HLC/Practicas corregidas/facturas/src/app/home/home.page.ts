import { Component } from '@angular/core';
import { NavController } from '@ionic/angular';
import { ApiServiceProvider } from 'src/providers/api-service/api-service';
import { Factura } from '../modelo/Factura';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  facturas: Factura[] = new Array();

  constructor(private apiService: ApiServiceProvider,
    private navCtrl: NavController) {
  }

  ngOnInit(): void {
  }

  ionViewWillEnter(){
    this.apiService.getFacturas()
    .then((facturas: Factura[]) => {
      this.facturas = facturas;
    })
    .catch((error: string) => {
      console.log(error);
    });
  }

  nuevaFactura() {
    this.navCtrl.navigateForward('/nueva-factura');
  }

}
