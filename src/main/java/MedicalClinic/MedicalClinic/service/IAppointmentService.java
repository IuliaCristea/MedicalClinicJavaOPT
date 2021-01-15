package MedicalClinic.MedicalClinic.service;

import MedicalClinic.MedicalClinic.model.Appointment;

import java.util.List;

public interface IAppointmentService {
    Appointment addAppointment(Appointment appointment) throws Exception;
    List<Appointment> getAllAppointmentsByDoctor(int doctorId) throws Exception;
    List<Appointment> getAllAppointmentsByPatient(int patientId) throws Exception;
    Appointment updateAppointment(Appointment appointment) throws Exception;
    boolean deleteAppointment(int appointmentId) throws Exception;
}
