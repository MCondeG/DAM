import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PAGINA5Page } from './pagina5.page';

const routes: Routes = [
  {
    path: '',
    component: PAGINA5Page
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PAGINA5PageRoutingModule {}
