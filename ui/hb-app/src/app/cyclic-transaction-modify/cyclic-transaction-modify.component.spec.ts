import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {CyclicTransactionModifyComponent} from './cyclic-transaction-modify.component';

describe('CyclicTransactionModifyComponent', () => {
  let component: CyclicTransactionModifyComponent;
  let fixture: ComponentFixture<CyclicTransactionModifyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CyclicTransactionModifyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CyclicTransactionModifyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
