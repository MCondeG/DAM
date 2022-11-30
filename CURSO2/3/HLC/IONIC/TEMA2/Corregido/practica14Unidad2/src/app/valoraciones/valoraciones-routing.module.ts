import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ValoracionesPage } from './valoraciones.page';

const routes: Routes = [
  {
    path: '',
    component: ValoracionesPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ValoracionesPageRoutingModule {}
