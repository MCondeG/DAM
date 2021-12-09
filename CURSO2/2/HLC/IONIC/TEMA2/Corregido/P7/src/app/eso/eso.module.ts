import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { EsoPageRoutingModule } from './eso-routing.module';

import { EsoPage } from './eso.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    EsoPageRoutingModule
  ],
  declarations: [EsoPage]
})
export class EsoPageModule {}
