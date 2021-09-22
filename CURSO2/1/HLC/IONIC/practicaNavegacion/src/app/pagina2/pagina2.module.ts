import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { PAGINA2PageRoutingModule } from './pagina2-routing.module';

import { PAGINA2Page } from './pagina2.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    PAGINA2PageRoutingModule
  ],
  declarations: [PAGINA2Page]
})
export class PAGINA2PageModule {}
