package MedicalClinic.MedicalClinic.service;

import MedicalClinic.MedicalClinic.model.Patient;

import java.util.List;

public interface IPatientService {

    Patient addPatient(Patient patient) throws Exception;
    List<Patient> getAllPatients() throws Exception;
    Patient getPatientByName(String name) throws Exception;
    Patient getPatientByCNP(String cnp) throws Exception;
    Patient updatePatient(Patient patient) throws Exception;
    boolean deletePatient(int id) throws Exception;
}
