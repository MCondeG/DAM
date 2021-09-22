import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { PAGINA5Page } from './pagina5.page';

describe('PAGINA5Page', () => {
  let component: PAGINA5Page;
  let fixture: ComponentFixture<PAGINA5Page>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PAGINA5Page ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(PAGINA5Page);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
