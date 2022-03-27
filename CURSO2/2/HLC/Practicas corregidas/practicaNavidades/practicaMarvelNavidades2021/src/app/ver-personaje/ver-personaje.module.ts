import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { VerPersonajePageRoutingModule } from './ver-personaje-routing.module';

import { VerPersonajePage } from './ver-personaje.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    VerPersonajePageRoutingModule
  ],
  declarations: [VerPersonajePage]
})
export class VerPersonajePageModule {}
