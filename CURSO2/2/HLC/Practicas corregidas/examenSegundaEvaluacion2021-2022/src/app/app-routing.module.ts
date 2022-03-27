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
    path: 'nueva-reserva',
    loadChildren: () => import('./nueva-reserva/nueva-reserva.module').then( m => m.NuevaReservaPageModule)
  },
  {
    path: 'buscar-reservas',
    loadChildren: () => import('./buscar-reservas/buscar-reservas.module').then( m => m.BuscarReservasPageModule)
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
