import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AddPartidoPage } from './add-partido.page';

const routes: Routes = [
  {
    path: '',
    component: AddPartidoPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AddPartidoPageRoutingModule {}
