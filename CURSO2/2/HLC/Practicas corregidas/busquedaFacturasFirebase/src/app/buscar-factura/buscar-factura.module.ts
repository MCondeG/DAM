import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { BuscarFacturaPageRoutingModule } from './buscar-factura-routing.module';

import { BuscarFacturaPage } from './buscar-factura.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    BuscarFacturaPageRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [BuscarFacturaPage]
})
export class BuscarFacturaPageModule {}
