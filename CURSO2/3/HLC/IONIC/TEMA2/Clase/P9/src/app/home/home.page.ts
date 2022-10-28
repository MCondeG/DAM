import { Component } from '@angular/core';
import { Producto } from '../modelo/Producto';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {


  producto: Producto;
  productos: Producto[];

  id: number;
  ids: number[];

  constructor() {

    this.producto = null;
    this.productos = [
      {"id": 0, "descripcion": "pan", "precio": 0.5},
      {"id": 1, "descripcion": "manzana", "precio": 0.3},
      {"id": 2, "descripcion": "papel higiénico", "precio": 2},
      {"id": 3, "descripcion": "pechuga pollo", "precio": 3.5},
      {"id": 4, "descripcion": "huevos", "precio": 1.9}
    ];

    this.id = null;
    this.ids = [0, 1, 2, 3];
  }
}