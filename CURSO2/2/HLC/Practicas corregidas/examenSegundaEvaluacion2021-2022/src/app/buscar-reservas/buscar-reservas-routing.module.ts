import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { BuscarReservasPage } from './buscar-reservas.page';

const routes: Routes = [
  {
    path: '',
    component: BuscarReservasPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class BuscarReservasPageRoutingModule {}
