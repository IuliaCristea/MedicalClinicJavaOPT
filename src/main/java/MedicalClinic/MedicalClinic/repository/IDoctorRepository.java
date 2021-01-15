package MedicalClinic.MedicalClinic.repository;

import MedicalClinic.MedicalClinic.model.Doctor;

import java.util.List;

public interface IDoctorRepository {
    Doctor addDoctor(Doctor doctor) throws Exception;
    List<Doctor> getAllDoctorsByClinic(int clinicid) throws Exception;
    List<Doctor> getAllDoctorsBySpecialty(String specialty) throws Exception;
    List<Doctor> getAllDoctorsByClinicAndSpecialty(int clinicId, String specialty) throws Exception;
    Doctor getDoctorByName(String name) throws Exception;
    Doctor updateDoctor(Doctor doctor) throws Exception;
    boolean deleteDoctor(int id) throws Exception;
}
