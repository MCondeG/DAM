import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { AltaCorredorPage } from './alta-corredor.page';

describe('AltaCorredorPage', () => {
  let component: AltaCorredorPage;
  let fixture: ComponentFixture<AltaCorredorPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AltaCorredorPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(AltaCorredorPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
