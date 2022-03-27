import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { NuevaFacturaPage } from './nueva-factura.page';

const routes: Routes = [
  {
    path: '',
    component: NuevaFacturaPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class NuevaFacturaPageRoutingModule {}
