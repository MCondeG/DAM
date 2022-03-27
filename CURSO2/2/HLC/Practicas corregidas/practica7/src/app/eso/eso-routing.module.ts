import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { EsoPage } from './eso.page';

const routes: Routes = [
  {
    path: '',
    component: EsoPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class EsoPageRoutingModule {}
