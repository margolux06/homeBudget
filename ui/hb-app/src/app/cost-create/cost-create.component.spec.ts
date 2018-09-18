import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {CostCreateComponent} from './cost-create.component';

describe('CostCreateComponent', () => {
  let component: CostCreateComponent;
  let fixture: ComponentFixture<CostCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CostCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CostCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
