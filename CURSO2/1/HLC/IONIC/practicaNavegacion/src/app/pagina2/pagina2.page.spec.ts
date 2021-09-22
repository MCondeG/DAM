import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { PAGINA2Page } from './pagina2.page';

describe('PAGINA2Page', () => {
  let component: PAGINA2Page;
  let fixture: ComponentFixture<PAGINA2Page>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PAGINA2Page ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(PAGINA2Page);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
