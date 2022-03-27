import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { Ejejercicio1PageRoutingModule } from './ejejercicio1-routing.module';

import { Ejejercicio1Page } from './ejejercicio1.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ReactiveFormsModule,
    Ejejercicio1PageRoutingModule
  ],
  declarations: [Ejejercicio1Page]
})
export class Ejejercicio1PageModule {}
