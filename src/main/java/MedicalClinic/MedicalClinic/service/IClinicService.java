package MedicalClinic.MedicalClinic.service;

import MedicalClinic.MedicalClinic.model.Clinic;
import java.util.List;
public interface IClinicService {
    Clinic addClinic(Clinic clinic) throws Exception;
    List<Clinic> getAllClinics() throws Exception;
    Clinic getClinicByName(String name) throws Exception;
    Clinic updateClinic(Clinic clinic) throws Exception;
    boolean deleteClinic(int id) throws Exception;
}
