import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { VerComicPageRoutingModule } from './ver-comic-routing.module';

import { VerComicPage } from './ver-comic.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    VerComicPageRoutingModule
  ],
  declarations: [VerComicPage]
})
export class VerComicPageModule {}
