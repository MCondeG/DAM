import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PAGINA4Page } from './pagina4.page';

const routes: Routes = [
  {
    path: '',
    component: PAGINA4Page
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PAGINA4PageRoutingModule {}
