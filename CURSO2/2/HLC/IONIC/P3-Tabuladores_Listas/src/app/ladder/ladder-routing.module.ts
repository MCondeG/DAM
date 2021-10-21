import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LadderPage } from './ladder.page';

const routes: Routes = [
  {
    path: '',
    component: LadderPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class LadderPageRoutingModule {}
