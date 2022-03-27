import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { Pagina2Page } from './pagina2.page';

const routes: Routes = [
  {
    path: 'pagina2',
    component: Pagina2Page,
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
        path: 'pagina2',
        redirectTo: '/pagina2/tab1',
        pathMatch: 'full'
      }
    ]
  },
  {
    path: '',
    redirectTo: '/pagina2/tabs1',
    pathMatch: 'full'
  }];



@NgModule({
  imports: [RouterModule.forChild(routes)],
})
export class Pagina2PageRoutingModule { }
