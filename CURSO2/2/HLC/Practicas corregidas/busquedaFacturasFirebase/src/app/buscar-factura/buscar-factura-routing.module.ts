import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { BuscarFacturaPage } from './buscar-factura.page';

const routes: Routes = [
  {
    path: '',
    component: BuscarFacturaPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class BuscarFacturaPageRoutingModule {}
