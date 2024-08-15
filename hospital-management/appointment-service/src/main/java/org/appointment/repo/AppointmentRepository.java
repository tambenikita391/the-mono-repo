package org.appointment.repo;

import java.util.List;
import java.util.Optional;

import org.appointment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AppointmentRepository extends JpaRepository<Appointment, String> {

  Optional<Appointment> findByPatientId(String patientId);

List<Appointment> findByAppointmentId(String appointmentId);}
