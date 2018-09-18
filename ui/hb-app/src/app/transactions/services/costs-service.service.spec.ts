import {inject, TestBed} from '@angular/core/testing';

import {CostsService} from './costs.service';

describe('CostsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CostsService]
    });
  });

  it('should be created', inject([CostsService], (service: CostsService) => {
    expect(service).toBeTruthy();
  }));
});
