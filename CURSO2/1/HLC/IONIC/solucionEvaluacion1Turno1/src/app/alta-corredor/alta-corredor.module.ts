import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { AltaCorredorPageRoutingModule } from './alta-corredor-routing.module';

import { AltaCorredorPage } from './alta-corredor.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    AltaCorredorPageRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [AltaCorredorPage]
})
export class AltaCorredorPageModule {}
