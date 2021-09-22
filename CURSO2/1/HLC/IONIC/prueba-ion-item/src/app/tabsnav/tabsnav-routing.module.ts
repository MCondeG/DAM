import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TabsnavPage } from './tabsnav.page';

const routes: Routes = [
  {
    path: 'tabs-nav',
    component: TabsnavPage,
    children: [
      {
        path: 'groceries',
        loadChildren: () => import('../groceries/groceries.module').then(m => m.GroceriesPageModule)
      },
      {
        path: 'notes',
        loadChildren: () => import('../notes/notes.module').then(m => m.NotesPageModule)
      },
      {
        path: 'contacts',
        loadChildren: () => import('../contacts/contacts.module').then(m => m.ContactsPageModule)
      },
      {
        path: 'ladder',
        loadChildren: () => import('../ladder/ladder.module').then(m => m.LadderPageModule)
      }
    ]
  },
  {
    path: '',
    redirectTo: '/tabs-nav/groceries'
  }
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TabsnavPageRoutingModule { }