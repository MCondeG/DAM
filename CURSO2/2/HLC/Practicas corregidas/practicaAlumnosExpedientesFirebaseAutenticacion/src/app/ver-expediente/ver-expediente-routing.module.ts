import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { VerExpedientePage } from './ver-expediente.page';

const routes: Routes = [
  {
    path: '',
    component: VerExpedientePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class VerExpedientePageRoutingModule {}
