import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ReservasUsuarioPageRoutingModule } from './reservas-usuario-routing.module';

import { ReservasUsuarioPage } from './reservas-usuario.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ReservasUsuarioPageRoutingModule
  ],
  declarations: [ReservasUsuarioPage]
})
export class ReservasUsuarioPageModule {}
