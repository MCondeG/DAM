import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { GroceriesPage } from './groceries.page';

describe('GroceriesPage', () => {
  let component: GroceriesPage;
  let fixture: ComponentFixture<GroceriesPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GroceriesPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(GroceriesPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
