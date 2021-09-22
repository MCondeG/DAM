import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ReservasUsuarioPage } from './reservas-usuario.page';

const routes: Routes = [
  {
    path: '',
    component: ReservasUsuarioPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ReservasUsuarioPageRoutingModule {}
