import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {OnetimeTransactionModifyComponent} from './onetime-transaction-modify.component';

describe('OnetimeTransactionModifyComponent', () => {
  let component: OnetimeTransactionModifyComponent;
  let fixture: ComponentFixture<OnetimeTransactionModifyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OnetimeTransactionModifyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OnetimeTransactionModifyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
