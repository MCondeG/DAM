import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { ApiServiceProvider } from 'src/providers/api-service/api-service';
import { DetalleProducto } from '../modelo/DetalleProducto';
import { Producto } from '../modelo/Producto';

@Component({
  selector: 'app-add-producto',
  templateUrl: './add-producto.page.html',
  styleUrls: ['./add-producto.page.scss'],
})
export class AddProductoPage implements OnInit {

  productos:Producto[]=new Array();
  productoSeleccionado:Producto=new Producto();
  unidades:number=1;

  constructor(public modalCtrl: ModalController,
    private apiService: ApiServiceProvider,) { }

  ngOnInit(): void {
    this.apiService.getProductos()
      .then((productos: Producto[]) => {
        this.productos = productos;
      })
      .catch((error: string) => {
        console.log(error);
      });
  }

  seleccionadoProducto(){
    console.log(this.productoSeleccionado);
  }

  submit() {
    let detalleProducto:DetalleProducto=new DetalleProducto();
    detalleProducto.descripcion=this.productoSeleccionado.descripcion;
    detalleProducto.unidades=1;
    detalleProducto.importeUnitario=this.productoSeleccionado.importeUnitario;
    detalleProducto.unidades=this.unidades;
    this.modalCtrl.dismiss(JSON.stringify(detalleProducto)); 
  }

  validarSubmit():boolean{
    if(this.productoSeleccionado.id==null)
      return false;
    if(!(this.unidades>0))
      return false;
    return true;
  }

  cancel(){
    this.modalCtrl.dismiss(); 
  }

}
