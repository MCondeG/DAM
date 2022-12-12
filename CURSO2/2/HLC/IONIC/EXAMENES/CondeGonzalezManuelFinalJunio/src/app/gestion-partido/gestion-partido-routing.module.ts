import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GestionPartidoPage } from './gestion-partido.page';

const routes: Routes = [
  {
    path: '',
    component: GestionPartidoPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class GestionPartidoPageRoutingModule {}
