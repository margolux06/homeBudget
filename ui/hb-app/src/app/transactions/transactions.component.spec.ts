import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {Transactions} from './transactions.component';

describe('Transactions', () => {
  let component: Transactions;
  let fixture: ComponentFixture<Transactions>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Transactions ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Transactions);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
