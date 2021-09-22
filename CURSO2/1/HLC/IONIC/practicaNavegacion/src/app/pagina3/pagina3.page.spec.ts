import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { PAGINA3Page } from './pagina3.page';

describe('PAGINA3Page', () => {
  let component: PAGINA3Page;
  let fixture: ComponentFixture<PAGINA3Page>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PAGINA3Page ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(PAGINA3Page);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
