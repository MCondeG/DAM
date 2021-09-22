import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ListadoCorredoresPage } from './listado-corredores.page';

describe('ListadoCorredoresPage', () => {
  let component: ListadoCorredoresPage;
  let fixture: ComponentFixture<ListadoCorredoresPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListadoCorredoresPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ListadoCorredoresPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
