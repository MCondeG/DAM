import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { VerPersonajePage } from './ver-personaje.page';

const routes: Routes = [
  {
    path: '',
    component: VerPersonajePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class VerPersonajePageRoutingModule {}
