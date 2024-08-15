package org.cases.service;

import java.util.List;

import org.cases.common.RandomStringGenerator;
import org.cases.common.ResponseCode;
import org.cases.dto.CaseRequest;
import org.cases.dto.CaseResponse;
import org.cases.entity.Cases;
import org.cases.repo.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Component

public class CaseManagementServiceImpl implements CaseManagementService {

  @Autowired CaseRepository caseRepo;

  @Autowired CaseResponse caseResponse;

  @Autowired CaseRequest caseRequest;

  public CaseResponse addCases(CaseRequest caseRequest) {
    Cases cases =
        Cases.getInstanace()
            .setPatientNameInEnglish(caseRequest.getPatientNameInEnglish())
            .setPatientNameInMarathi(caseRequest.getPatientNameInMarathi())
            .setCaseId("CASE" + RandomStringGenerator.generateRandomString(5))
            .setPatientId("PAT" + RandomStringGenerator.generateRandomString(5))
            .setExaminationDate(caseRequest.getExaminationDate())
            .setSymptoms(caseRequest.getSymptoms())
            .setPrescription(caseRequest.getPrescription());
    try {
      cases = caseRepo.save(cases);
    } catch (Exception e) {
      e.printStackTrace();
    }
    caseResponse.setStatus(ResponseCode.ADD_CASES_SUCCESS.getStatus());
    caseResponse.setMessage(ResponseCode.ADD_CASES_SUCCESS.getMessage());
    caseResponse.setCaseId(cases.getCaseId());
    caseResponse.setPatientId(cases.getPatientId());

    return caseResponse;
  }

  public CaseResponse getCasesByCaseId(String caseId) {
    List<Cases> receivedCases = caseRepo.findByCaseId(caseId);
    if (receivedCases.isEmpty() || receivedCases == null) {
      caseResponse.setStatus(ResponseCode.SEARCH_CASES_FAILURE.getStatus());
      caseResponse.setMessage(ResponseCode.SEARCH_CASES_FAILURE.getMessage());
    } else {
      Cases cases = receivedCases.get(0);
      caseResponse.setPatientNameInEnglish(cases.getPatientNameInEnglish());
      caseResponse.setPatientNameInMarathi(cases.getPatientNameInMarathi());
      caseResponse.setCaseId(cases.getCaseId());
      caseResponse.setExaminationDate(cases.getExaminationDate());
      caseResponse.setSymptoms(cases.getSymptoms());
      caseResponse.setPrescription(cases.getPrescription());
      caseResponse.setCaseId(cases.getCaseId());
      caseResponse.setPatientId(cases.getPatientId());

      caseResponse.setStatus(ResponseCode.SEARCH_CASES_SUCCESS.getStatus());
      caseResponse.setMessage(ResponseCode.SEARCH_CASES_SUCCESS.getMessage());
    }
    return caseResponse;
  }

  public CaseResponse searchCasesByPatientId(String patientId) {
    List<Cases> receivedCases = caseRepo.findByPatientId(patientId);
    if (receivedCases.isEmpty() || receivedCases == null) {
      caseResponse.setStatus(ResponseCode.SEARCH_CASES_FAILURE.getStatus());
      caseResponse.setMessage(ResponseCode.SEARCH_CASES_FAILURE.getMessage());
    } else {
      Cases cases = receivedCases.get(0);
      caseResponse.setPatientNameInEnglish(cases.getPatientNameInEnglish());
      caseResponse.setPatientNameInMarathi(cases.getPatientNameInMarathi());
      caseResponse.setCaseId(cases.getCaseId());
      caseResponse.setExaminationDate(cases.getExaminationDate());
      caseResponse.setSymptoms(cases.getSymptoms());
      caseResponse.setPrescription(cases.getPrescription());
      caseResponse.setCaseId(cases.getCaseId());
      caseResponse.setPatientId(cases.getPatientId());

      caseResponse.setStatus(ResponseCode.SEARCH_CASES_SUCCESS.getStatus());
      caseResponse.setMessage(ResponseCode.SEARCH_CASES_SUCCESS.getMessage());
    }
    return caseResponse;
  }

  public CaseResponse updateCases(String caseId, CaseRequest caseRequest) {
    List<Cases> receivedCases = caseRepo.findByCaseId(caseId);
    if (receivedCases.isEmpty() || receivedCases == null) {
      caseResponse.setStatus(ResponseCode.UPDATE_CASES_FAILURE.getStatus());
      caseResponse.setMessage(ResponseCode.UPDATE_CASES_FAILURE.getMessage());
    } else {
      Cases cases =
          Cases.getInstanace()
              .setPatientNameInEnglish(caseRequest.getPatientNameInEnglish())
              .setPatientNameInMarathi(caseRequest.getPatientNameInMarathi())
              .setCaseId("CASE" + RandomStringGenerator.generateRandomString(5))
              .setPatientId("PAT" + RandomStringGenerator.generateRandomString(5))
              .setExaminationDate(caseRequest.getExaminationDate())
              .setSymptoms(caseRequest.getSymptoms())
              .setPrescription(caseRequest.getPrescription());
      try {
        cases = caseRepo.save(cases);
      } catch (Exception e) {
        e.printStackTrace();
      }
      populatedCaseResponse(caseResponse, cases);
      caseResponse.setStatus(ResponseCode.UPDATE_CASES_SUCCESS.getStatus());
      caseResponse.setMessage(ResponseCode.UPDATE_CASES_SUCCESS.getMessage());
      caseResponse.setCaseId(cases.getCaseId());
      caseResponse.setPatientId(cases.getPatientId());
    }
    return caseResponse;
  }

  @Transactional
  public CaseResponse deleteCase(String caseId) {
	    List<Cases> receivedData = caseRepo.findByCaseId(caseId);

	    if (receivedData.isEmpty()) {
	      caseResponse.setMessage(ResponseCode.SEARCH_CASES_FAILURE.getMessage());
	      caseResponse.setStatus(ResponseCode.SEARCH_CASES_FAILURE.getStatus());
	    } else {
	      Cases cases = receivedData.get(0);
	      cases.setStatus(Cases.Status.DELETED);
	      caseRepo.save(cases);

	      caseResponse.setMessage(ResponseCode.DELETE_CASES_SUCCESS.getMessage());
	      caseResponse.setStatus(ResponseCode.DELETE_CASES_SUCCESS.getStatus());
	      populatedCaseResponse(caseResponse, cases);
	    }
	    return caseResponse;
	  }
  private void populatedCaseResponse(CaseResponse response, Cases cases) {
	    response.setExaminationDate(cases.getExaminationDate());
	    response.setPatientId(cases.getPatientId());
	    response.setPatientNameInEnglish(cases.getPatientNameInEnglish());
	    response.setPatientNameInMarathi(cases.getPatientNameInMarathi());
	    response.setPrescription(cases.getPrescription());
	    response.setSymptoms(cases.getSymptoms());
	  }
}
