import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { VerComicPage } from './ver-comic.page';

const routes: Routes = [
  {
    path: '',
    component: VerComicPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class VerComicPageRoutingModule {}
