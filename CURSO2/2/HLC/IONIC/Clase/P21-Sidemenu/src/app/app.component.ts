import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  public appPages = [
    { title: 'Página 1', url: '/pagina1', icon: 'mail' },
    { title: 'Página 2', url: '/pagina2', icon: 'paper-plane' },
    { title: 'Página 3', url: '/pagina3', icon: 'heart' },
  ];
  constructor() {}
}