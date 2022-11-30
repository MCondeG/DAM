import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { Pagina1Page } from './pagina1.page';

const routes: Routes = [
  {
    path: 'pagina1',
    component: Pagina1Page,
    children: [
      {
        path: 'tabs1',
        loadChildren: () => import('../tabs1/tabs1.module').then(m => m.Tabs1PageModule)
      },
      {
        path: 'tabs2',
        loadChildren: () => import('../tabs2/tabs2.module').then(m => m.Tabs2PageModule)
      },
      {
        path: '',
        redirectTo: '/pagina1/tabs1',
        pathMatch: 'full'
      }
    ]
  },
  {
    path: '',
    redirectTo: '/pagina1/tabs1',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class Pagina1PageRoutingModule {}