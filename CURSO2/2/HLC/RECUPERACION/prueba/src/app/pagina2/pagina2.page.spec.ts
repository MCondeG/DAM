import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { Pagina2Page } from './pagina2.page';

describe('Pagina2Page', () => {
  let component: Pagina2Page;
  let fixture: ComponentFixture<Pagina2Page>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Pagina2Page ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(Pagina2Page);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
