import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { PAGINA4PageRoutingModule } from './pagina4-routing.module';

import { PAGINA4Page } from './pagina4.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    PAGINA4PageRoutingModule
  ],
  declarations: [PAGINA4Page]
})
export class PAGINA4PageModule {}
