import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PAGINA3Page } from './pagina3.page';

const routes: Routes = [
  {
    path: '',
    component: PAGINA3Page
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PAGINA3PageRoutingModule {}
