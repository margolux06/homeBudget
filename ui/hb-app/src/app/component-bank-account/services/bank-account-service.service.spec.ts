import { TestBed, inject } from '@angular/core/testing';

import { BankAccountServiceService } from './bank-account-service.service';

describe('BankAccountServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BankAccountServiceService]
    });
  });

  it('should be created', inject([BankAccountServiceService], (service: BankAccountServiceService) => {
    expect(service).toBeTruthy();
  }));
});
