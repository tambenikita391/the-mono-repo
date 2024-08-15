package org.cases.service;

import org.cases.dto.CaseRequest;
import org.cases.dto.CaseResponse;
import org.cases.entity.Cases;
import org.springframework.transaction.annotation.Transactional;

public interface CaseManagementService {
  public CaseResponse addCases(CaseRequest caseRequest);

  public CaseResponse deleteCase(String caseId);

  public CaseResponse getCasesByCaseId(String caseId);

  public CaseResponse searchCasesByPatientId(String patientId);
}
