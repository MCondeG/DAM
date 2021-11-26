import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GroceriesPage } from './groceries.page';

const routes: Routes = [
  {
    path: '',
    component: GroceriesPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class GroceriesPageRoutingModule {}
