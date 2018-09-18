import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {TransactionModifyComponent} from './transaction-modify.component';

describe('TransactionModifyComponent', () => {
  let component: TransactionModifyComponent;
  let fixture: ComponentFixture<TransactionModifyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TransactionModifyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TransactionModifyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
