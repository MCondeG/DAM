import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { Pagina4Page } from './pagina4.page';

const routes: Routes = [
  {
    path: '',
    component: Pagina4Page
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class Pagina4PageRoutingModule {}
