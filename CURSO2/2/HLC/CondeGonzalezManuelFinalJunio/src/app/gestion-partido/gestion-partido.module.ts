import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { GestionPartidoPageRoutingModule } from './gestion-partido-routing.module';

import { GestionPartidoPage } from './gestion-partido.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    GestionPartidoPageRoutingModule
  ],
  declarations: [GestionPartidoPage]
})
export class GestionPartidoPageModule {}
