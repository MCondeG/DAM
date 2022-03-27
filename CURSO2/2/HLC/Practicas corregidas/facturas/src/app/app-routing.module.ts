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
    path: 'nueva-factura',
    loadChildren: () => import('./nueva-factura/nueva-factura.module').then( m => m.NuevaFacturaPageModule)
  },
  {
    path: 'add-producto',
    loadChildren: () => import('./add-producto/add-producto.module').then( m => m.AddProductoPageModule)
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
