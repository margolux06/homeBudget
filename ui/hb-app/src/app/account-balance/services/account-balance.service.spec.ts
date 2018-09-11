import { TestBed, inject } from '@angular/core/testing';

import { AccountBalanceService } from './account-balance.service';

describe('AccountBalanceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AccountBalanceService]
    });
  });

  it('should be created', inject([AccountBalanceService], (service: AccountBalanceService) => {
    expect(service).toBeTruthy();
  }));
});
