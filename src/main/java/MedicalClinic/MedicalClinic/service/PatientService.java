package MedicalClinic.MedicalClinic.service;

import MedicalClinic.MedicalClinic.model.Patient;
import MedicalClinic.MedicalClinic.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientService implements IPatientService {

    @Autowired
    private IPatientRepository patientRepository;

    public Patient addPatient(Patient patient) throws Exception {
        return patientRepository.addPatient(patient);
    }

    public List<Patient> getAllPatients() throws Exception {
        return patientRepository.getAllPatients();
    }

    @Override
    public Patient getPatientByName(String name) throws Exception {
        return patientRepository.getPatientByName(name);
    }

    @Override
    public Patient getPatientByCNP(String cnp) throws Exception {
        return patientRepository.getPatientByCNP(cnp);
    }

    @Override
    public Patient updatePatient(Patient patient) throws Exception {
        return patientRepository.updatePatient(patient);
    }

    @Override
    public boolean deletePatient(int id) throws Exception {
        return patientRepository.deletePatient(id);
    }
}
