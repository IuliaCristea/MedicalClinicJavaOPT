package MedicalClinic.MedicalClinic.service;

import MedicalClinic.MedicalClinic.model.Clinic;
import MedicalClinic.MedicalClinic.repository.IClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService implements IClinicService {

    @Autowired
    private IClinicRepository clinicRepository;

    @Override
    public Clinic addClinic(Clinic clinic) throws Exception {
        return clinicRepository.addClinic(clinic);
    }

    @Override
    public List<Clinic> getAllClinics() throws Exception {
        return clinicRepository.getAllClinics();
    }

    @Override
    public Clinic getClinicByName(String name) throws Exception {
        return clinicRepository.getClinicByName(name);
    }

    @Override
    public Clinic updateClinic(Clinic clinic) throws Exception {
        return clinicRepository.updateClinic(clinic);
    }

    @Override
    public boolean deleteClinic(int id) throws Exception {
        return clinicRepository.deleteClinic(id);
    }
}
