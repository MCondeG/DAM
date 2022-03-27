import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { VerDocumentoPageRoutingModule } from './ver-documento-routing.module';

import { VerDocumentoPage } from './ver-documento.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    VerDocumentoPageRoutingModule
  ],
  declarations: [VerDocumentoPage]
})
export class VerDocumentoPageModule {}
