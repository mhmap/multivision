import { TestBed } from '@angular/core/testing';

import { LabseqServiceService } from './labseq-service.service';

describe('LabseqServiceService', () => {
  let service: LabseqServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LabseqServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
