import {inject, TestBed} from '@angular/core/testing';

import {CyclicTransactionService} from './cyclic-transaction.service';

describe('CyclicTransactionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CyclicTransactionService]
    });
  });

  it('should be created', inject([CyclicTransactionService], (service: CyclicTransactionService) => {
    expect(service).toBeTruthy();
  }));
});
