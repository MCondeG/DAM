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
    path: 'alta-corredor',
    loadChildren: () => import('./alta-corredor/alta-corredor.module').then( m => m.AltaCorredorPageModule)
  },
  {
    path: 'listado-corredores',
    loadChildren: () => import('./listado-corredores/listado-corredores.module').then( m => m.ListadoCorredoresPageModule)
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
