import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { NuevaReservaPage } from './nueva-reserva.page';

const routes: Routes = [
  {
    path: '',
    component: NuevaReservaPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class NuevaReservaPageRoutingModule {}
