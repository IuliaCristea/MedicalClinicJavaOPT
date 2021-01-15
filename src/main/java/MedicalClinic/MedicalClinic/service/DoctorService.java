package MedicalClinic.MedicalClinic.service;

import MedicalClinic.MedicalClinic.model.Doctor;
import MedicalClinic.MedicalClinic.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements IDoctorService {

    @Autowired
    private IDoctorRepository doctorRepository;

    @Override
    public Doctor addDoctor(Doctor doctor) throws Exception {
        return doctorRepository.addDoctor(doctor);
    }

    @Override
    public List<Doctor> getAllDoctorsByClinic(int clinicid) throws Exception {
        return doctorRepository.getAllDoctorsByClinic(clinicid);
    }

    @Override
    public List<Doctor> getAllDoctorsBySpecialty(String specialty) throws Exception {
        return doctorRepository.getAllDoctorsBySpecialty(specialty);
    }

    @Override
    public List<Doctor> getAllDoctorsByClinicAndSpecialty(int clinicId, String specialty) throws Exception {
        return doctorRepository.getAllDoctorsByClinicAndSpecialty(clinicId, specialty);
    }

    @Override
    public Doctor getDoctorByName(String name) throws Exception {
        return doctorRepository.getDoctorByName(name);
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) throws Exception {
        return doctorRepository.updateDoctor(doctor);
    }

    @Override
    public boolean deleteDoctor(int id) throws Exception {
        return doctorRepository.deleteDoctor(id);
    }
}
