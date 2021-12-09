import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  public appPages = [
    { title: 'Página 1', url: '/pagina1', icon: 'mail' },
    { title: 'Página 2', url: '/', icon: 'paper-plane' },
    { title: 'Página 3', url: '/pagina3', icon: 'heart' }
  ];
  public labels = ['Family', 'Friends', 'Notes', 'Work', 'Travel', 'Reminders'];
  constructor() { }
}
