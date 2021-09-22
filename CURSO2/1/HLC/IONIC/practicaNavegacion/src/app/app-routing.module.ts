import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then( m => m.HomePageModule)
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'pagina2',
    loadChildren: () => import('./pagina2/pagina2.module').then( m => m.PAGINA2PageModule)
  },
  {
    path: 'pagina3',
    loadChildren: () => import('./pagina3/pagina3.module').then( m => m.PAGINA3PageModule)
  },
  {
    path: 'pagina4',
    loadChildren: () => import('./pagina4/pagina4.module').then( m => m.PAGINA4PageModule)
  },
  {
    path: 'pagina5',
    loadChildren: () => import('./pagina5/pagina5.module').then( m => m.PAGINA5PageModule)
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
