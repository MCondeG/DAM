import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { NuevaReservaPageRoutingModule } from './nueva-reserva-routing.module';

import { NuevaReservaPage } from './nueva-reserva.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    NuevaReservaPageRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [NuevaReservaPage]
})
export class NuevaReservaPageModule {}
