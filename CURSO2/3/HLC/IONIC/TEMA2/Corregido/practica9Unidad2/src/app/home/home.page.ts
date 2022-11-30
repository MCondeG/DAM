import { Component } from '@angular/core';
import { AlertController } from '@ionic/angular';
import { LineaDetalle } from '../modelo/LineaDetalle';
import { Producto } from '../modelo/Producto';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  private productoSeleccionado: Producto;
  private codigoSeleccionado: number;
  private productos: Producto[] = [];
  private lineasDetalle: LineaDetalle[] = [];
  private total:number=0.0;

  constructor(public alertController: AlertController) {
    this.productos.push(new Producto(1, "Producto 1", 10.3));
    this.productos.push(new Producto(2, "Producto 2", 25.3));
  }

  seleccionadoProducto(event) {
    //console.log(event.target.value);
    if (!this.codigoSeleccionado)
      return;
    this.productos.forEach(producto => {
      if (producto.codigo == this.codigoSeleccionado) {
        this.productoSeleccionado = producto;
      }
    });
    this.alertUnidadesProducto();
  }

  async alertUnidadesProducto() {
    const alert = await this.alertController.create({
      header: this.productoSeleccionado.codigo + ' - ' + this.productoSeleccionado.descripcion,
      inputs: [
        {
          type: 'number',
          name: 'unidades',
          placeholder: 'unidades',
          min: 1
        }
      ],
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          handler: () => {
            //borro la selección del ion-select
            this.codigoSeleccionado = null;
          },
        },
        {
          text: 'OK',
          role: 'confirm',
          handler: (data) => {
            let encontrado = false;
            let unidades = Number(data['unidades']);
            //busco en el array de lineas de detalle una linea
            //que tenga el mismo código de producto
            this.lineasDetalle.forEach((linea) => {
              if (linea.codigo == this.productoSeleccionado.codigo) {
                //ya está añadido el producto
                encontrado = true;
                //quito del total final el total del producto
                this.total-=linea.total;
                //actualizo las unidades y el total del producto
                linea.unidades += unidades;
                linea.total = linea.pvp * linea.unidades;
                //actualizo el total final
                this.total+=linea.total;
              }
            });
            if (!encontrado) {
              //el producto no ha sido aún añadido
              let lineaDetalle = new LineaDetalle(
                this.productoSeleccionado.codigo,
                this.productoSeleccionado.descripcion,
                this.productoSeleccionado.pvp,
                unidades,
                this.productoSeleccionado.pvp * unidades
              );
              this.lineasDetalle.push(lineaDetalle);
              //actualizo el total final
              this.total+=lineaDetalle.total;
            }
            //borro la selección del ion-select
            this.codigoSeleccionado = null;
          },
        }
      ]
    });
    await alert.present();
  }//end_alertUnidadesProducto

  eliminarLineaDetalle(i:number){
    //actualizo el total final
    this.total-=this.lineasDetalle[i].total;
    //elimino la linea de detalle
    this.lineasDetalle.splice(i,1);
  }

  async pedirConfirmacionBorrado(i:number) {
    const alert = await this.alertController.create({
      header: '¿Desea borrar?',
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
          handler: () => {
            this.eliminarLineaDetalle(i);
          },
        },
      ],
    });
    await alert.present();
  }//end_pedirConfirmacionBorrado

}//end_class
