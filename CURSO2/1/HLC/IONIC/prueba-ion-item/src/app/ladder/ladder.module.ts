import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { LadderPageRoutingModule } from './ladder-routing.module';

import { LadderPage } from './ladder.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    LadderPageRoutingModule
  ],
  declarations: [LadderPage]
})
export class LadderPageModule {}
