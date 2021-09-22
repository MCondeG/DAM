import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ListadoCorredoresPageRoutingModule } from './listado-corredores-routing.module';

import { ListadoCorredoresPage } from './listado-corredores.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ListadoCorredoresPageRoutingModule
  ],
  declarations: [ListadoCorredoresPage]
})
export class ListadoCorredoresPageModule {}
