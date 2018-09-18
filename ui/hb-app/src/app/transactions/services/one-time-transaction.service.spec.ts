import {inject, TestBed} from '@angular/core/testing';

import {OneTimeTransactionService} from './one-time-transaction.service';

describe('OneTimeTransactionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OneTimeTransactionService]
    });
  });

  it('should be created', inject([OneTimeTransactionService], (service: OneTimeTransactionService) => {
    expect(service).toBeTruthy();
  }));
});
