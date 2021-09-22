import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AltaCorredorPage } from './alta-corredor.page';

const routes: Routes = [
  {
    path: '',
    component: AltaCorredorPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AltaCorredorPageRoutingModule {}
