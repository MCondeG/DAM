import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AddProductoPage } from './add-producto.page';

const routes: Routes = [
  {
    path: '',
    component: AddProductoPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AddProductoPageRoutingModule {}
