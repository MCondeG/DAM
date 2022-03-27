import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { Ejercicio2Page } from './ejercicio2.page';

const routes: Routes = [
  {
    path: '',
    component: Ejercicio2Page
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class Ejercicio2PageRoutingModule {}
