import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ListadoCorredoresPage } from './listado-corredores.page';

const routes: Routes = [
  {
    path: '',
    component: ListadoCorredoresPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ListadoCorredoresPageRoutingModule {}
