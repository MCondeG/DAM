import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { VerExpedientePageRoutingModule } from './ver-expediente-routing.module';

import { VerExpedientePage } from './ver-expediente.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    VerExpedientePageRoutingModule
  ],
  declarations: [VerExpedientePage]
})
export class VerExpedientePageModule {}
