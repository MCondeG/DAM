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
    path: 'ejejercicio1',
    loadChildren: () => import('./ejejercicio1/ejejercicio1.module').then( m => m.Ejejercicio1PageModule)
  },
  {
    path: 'ejercicio2',
    loadChildren: () => import('./ejercicio2/ejercicio2.module').then( m => m.Ejercicio2PageModule)
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
