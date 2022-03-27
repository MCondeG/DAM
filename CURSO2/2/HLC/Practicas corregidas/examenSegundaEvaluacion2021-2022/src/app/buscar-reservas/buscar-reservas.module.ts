import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { BuscarReservasPageRoutingModule } from './buscar-reservas-routing.module';

import { BuscarReservasPage } from './buscar-reservas.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    BuscarReservasPageRoutingModule
  ],
  declarations: [BuscarReservasPage]
})
export class BuscarReservasPageModule {}
