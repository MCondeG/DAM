import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { PAGINA4Page } from './pagina4.page';

describe('PAGINA4Page', () => {
  let component: PAGINA4Page;
  let fixture: ComponentFixture<PAGINA4Page>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PAGINA4Page ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(PAGINA4Page);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
