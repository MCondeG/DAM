import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { Ejercicio2PageRoutingModule } from './ejercicio2-routing.module';

import { Ejercicio2Page } from './ejercicio2.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    Ejercicio2PageRoutingModule
  ],
  declarations: [Ejercicio2Page]
})
export class Ejercicio2PageModule {}
