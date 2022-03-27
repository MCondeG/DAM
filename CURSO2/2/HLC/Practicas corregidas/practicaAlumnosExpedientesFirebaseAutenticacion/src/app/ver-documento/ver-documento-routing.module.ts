import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { VerDocumentoPage } from './ver-documento.page';

const routes: Routes = [
  {
    path: '',
    component: VerDocumentoPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class VerDocumentoPageRoutingModule {}
