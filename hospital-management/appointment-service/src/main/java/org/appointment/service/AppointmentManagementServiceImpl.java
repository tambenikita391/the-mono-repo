package org.appointment.service;

import java.util.List;
import java.util.Optional;

import org.appointment.common.RandomStringGenerator;
import org.appointment.common.ResponseCode;
import org.appointment.dto.AppointmentRequest;
import org.appointment.dto.AppointmentResponse;
import org.appointment.entity.Appointment;
import org.appointment.repo.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class AppointmentManagementServiceImpl implements AppointmentManagementService {
  @Autowired AppointmentRepository appointmentRepo;
  @Autowired AppointmentRequest appointmentRequest;
  @Autowired AppointmentResponse appointmentResponse;

  public AppointmentResponse makeAppointment(AppointmentRequest appointmentRequest) {
    Appointment appointment =
        Appointment.getInstanace()
            .setPatientNameInEnglish(appointmentRequest.getPatientNameInEnglish())
            .setPatientNameInMarathi(appointmentRequest.getPatientNameInMarathi())
            .setAppointmentId("APMT" + RandomStringGenerator.generateRandomString(5))
            .setPatientId("PAT" + RandomStringGenerator.generateRandomString(5))
            .setExaminationDate(appointmentRequest.getExaminationDate())
            .setAppointmentTime(appointmentRequest.getAppointmentTime());

    try {
      appointment = appointmentRepo.save(appointment);
    } catch (Exception e) {
      e.printStackTrace();
    }

    appointmentResponse.setStatus(ResponseCode.ADD_APPOINTMENT_SUCCESS.getStatus());
    appointmentResponse.setMessage(ResponseCode.ADD_APPOINTMENT_SUCCESS.getMessage());
    appointmentResponse.setPatientId(appointment.getPatientId());
    appointmentResponse.setAppointmentId(appointment.getAppointmentId());
    return appointmentResponse;
  }

  public AppointmentResponse searchAppointment(String patientId) {
    Optional<Appointment> receivedAppointment = appointmentRepo.findByPatientId(patientId);
    if (receivedAppointment.isEmpty()) {
      appointmentResponse.setStatus(ResponseCode.SEARCH_APPOINTMENT_FAILURE.getStatus());
      appointmentResponse.setMessage(ResponseCode.SEARCH_APPOINTMENT_FAILURE.getMessage());
    } else {
      Appointment appointment = receivedAppointment.get();
      appointmentResponse.setPatientNameInEnglish(appointment.getPatientNameInEnglish());
      appointmentResponse.setPatientNameInMarathi(appointment.getPatientNameInMarathi());
      appointmentResponse.setAppointmentId(appointment.getAppointmentId());
      appointmentResponse.setExaminationDate(appointment.getExaminationDate());
      appointmentResponse.setAppointmentTime(appointment.getAppointmentTime());

      appointmentResponse.setStatus(ResponseCode.SEARCH_APPOINTMENT_SUCCESS.getStatus());
      appointmentResponse.setMessage(ResponseCode.SEARCH_APPOINTMENT_SUCCESS.getMessage());
    }

    return appointmentResponse;
  }

  public AppointmentResponse searchAppointmentByAppointmentId(String appointmentId) {
    List<Appointment> receivedAppointment = appointmentRepo.findByAppointmentId(appointmentId);
    if (receivedAppointment.isEmpty()) {
      appointmentResponse.setStatus(ResponseCode.SEARCH_APPOINTMENT_FAILURE.getStatus());
      appointmentResponse.setMessage(ResponseCode.SEARCH_APPOINTMENT_FAILURE.getMessage());
    } else {
      Appointment appointment = receivedAppointment.get(0);
      appointmentResponse.setPatientNameInEnglish(appointment.getPatientNameInEnglish());
      appointmentResponse.setPatientNameInMarathi(appointment.getPatientNameInMarathi());
      appointmentResponse.setAppointmentId(appointment.getAppointmentId());
      appointmentResponse.setExaminationDate(appointment.getExaminationDate());
      appointmentResponse.setAppointmentTime(appointment.getAppointmentTime());

      appointmentResponse.setStatus(ResponseCode.SEARCH_APPOINTMENT_SUCCESS.getStatus());
      appointmentResponse.setMessage(ResponseCode.SEARCH_APPOINTMENT_SUCCESS.getMessage());
    }

    return appointmentResponse;
  }

  public AppointmentResponse deleteAppointment(String appointmentId) {
    List<Appointment> optionalAppointment = appointmentRepo.findByAppointmentId(appointmentId);

    if (optionalAppointment.isEmpty()) {
      appointmentResponse.setStatus(ResponseCode.SEARCH_APPOINTMENT_SUCCESS.getStatus());
      appointmentResponse.setMessage(ResponseCode.SEARCH_APPOINTMENT_SUCCESS.getMessage());
    } else {
      Appointment appointment = optionalAppointment.get(0);
      appointment.setStatus(Appointment.Status.DELETED);
      appointmentRepo.save(appointment);

      appointmentResponse.setStatus(ResponseCode.SEARCH_APPOINTMENT_SUCCESS.getStatus());
      appointmentResponse.setMessage(ResponseCode.SEARCH_APPOINTMENT_SUCCESS.getMessage());
      populatedCaseResponse(appointmentResponse, appointment);
    }
    return appointmentResponse;
  }

  private void populatedCaseResponse(AppointmentResponse response, Appointment appointment) {
    response.setAppointmentId(appointment.getAppointmentTime());
    response.setExaminationDate(appointment.getExaminationDate());
    response.setPatientNameInEnglish(appointment.getPatientNameInEnglish());
    response.setPatientNameInMarathi(appointment.getPatientNameInMarathi());
  }
}
