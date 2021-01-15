package MedicalClinic.MedicalClinic.repository;

import MedicalClinic.MedicalClinic.model.Clinic;

import java.util.List;

public interface IClinicRepository {
    Clinic addClinic(Clinic clinic) throws Exception;
    List<Clinic> getAllClinics() throws Exception;
    Clinic getClinicByName(String name) throws Exception;
    Clinic updateClinic(Clinic clinic) throws Exception;
    boolean deleteClinic(int id) throws Exception;
}
