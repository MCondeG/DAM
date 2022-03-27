import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { NuevoEspedientePage } from './nuevo-espediente.page';

const routes: Routes = [
  {
    path: '',
    component: NuevoEspedientePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class NuevoEspedientePageRoutingModule {}
