import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { PAGINA3PageRoutingModule } from './pagina3-routing.module';

import { PAGINA3Page } from './pagina3.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    PAGINA3PageRoutingModule
  ],
  declarations: [PAGINA3Page]
})
export class PAGINA3PageModule {}
