package MedicalClinic.MedicalClinic.service;

import MedicalClinic.MedicalClinic.model.Appointment;
import MedicalClinic.MedicalClinic.repository.IAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService implements IAppointmentService {
    @Autowired
    private IAppointmentRepository appointmentRepository;

    @Override
    public Appointment addAppointment(Appointment appointment) throws Exception {
        return appointmentRepository.addAppointment(appointment);
    }

    @Override
    public List<Appointment> getAllAppointmentsByDoctor(int doctorId) throws Exception {
        return appointmentRepository.getAllAppointmentsByDoctor(doctorId);
    }

    @Override
    public List<Appointment> getAllAppointmentsByPatient(int patientId) throws Exception {
        return appointmentRepository.getAllAppointmentsByPatient(patientId);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) throws Exception {
        return appointmentRepository.updateAppointment(appointment);
    }

    @Override
    public boolean deleteAppointment(int appointmentId) throws Exception {
        return appointmentRepository.deleteAppointment(appointmentId);
    }
}
