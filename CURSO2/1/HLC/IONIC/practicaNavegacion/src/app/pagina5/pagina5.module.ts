import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { PAGINA5PageRoutingModule } from './pagina5-routing.module';

import { PAGINA5Page } from './pagina5.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    PAGINA5PageRoutingModule
  ],
  declarations: [PAGINA5Page]
})
export class PAGINA5PageModule {}
