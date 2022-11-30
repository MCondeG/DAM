import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ValoracionesPageRoutingModule } from './valoraciones-routing.module';

import { ValoracionesPage } from './valoraciones.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ValoracionesPageRoutingModule
  ],
  declarations: [ValoracionesPage]
})
export class ValoracionesPageModule {}
