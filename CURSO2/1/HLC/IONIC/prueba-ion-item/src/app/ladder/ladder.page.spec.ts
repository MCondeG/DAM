import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { LadderPage } from './ladder.page';

describe('LadderPage', () => {
  let component: LadderPage;
  let fixture: ComponentFixture<LadderPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LadderPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(LadderPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
