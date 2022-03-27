import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { Tabs1Page } from './tabs1.page';

const routes: Routes = [
  {
    path: '',
    component: Tabs1Page
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class Tabs1PageRoutingModule {}
