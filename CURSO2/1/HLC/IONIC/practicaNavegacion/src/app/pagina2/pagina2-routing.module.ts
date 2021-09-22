import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PAGINA2Page } from './pagina2.page';

const routes: Routes = [
  {
    path: '',
    component: PAGINA2Page
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PAGINA2PageRoutingModule {}
