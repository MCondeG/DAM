import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { NuevoEspedientePageRoutingModule } from './nuevo-espediente-routing.module';

import { NuevoEspedientePage } from './nuevo-espediente.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    NuevoEspedientePageRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [NuevoEspedientePage]
})
export class NuevoEspedientePageModule {}
