import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { Ejejercicio1Page } from './ejejercicio1.page';

const routes: Routes = [
  {
    path: '',
    component: Ejejercicio1Page
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class Ejejercicio1PageRoutingModule {}
