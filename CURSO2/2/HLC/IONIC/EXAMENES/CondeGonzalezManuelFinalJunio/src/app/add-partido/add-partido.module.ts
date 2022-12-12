import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { AddPartidoPageRoutingModule } from './add-partido-routing.module';

import { AddPartidoPage } from './add-partido.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    AddPartidoPageRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [AddPartidoPage]
})
export class AddPartidoPageModule {}
