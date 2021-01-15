package MedicalClinic.MedicalClinic.repository;

import MedicalClinic.MedicalClinic.Queries.PatientQueries;
import MedicalClinic.MedicalClinic.model.Patient;
import MedicalClinic.MedicalClinic.utils.Gender;
import MedicalClinic.MedicalClinic.utils.MyLogger;
import MedicalClinic.MedicalClinic.utils.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepository implements IPatientRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private PatientQueries patientQueries;
    @Autowired
    private MyLogger logger;


    public Patient addPatient(Patient patient) throws Exception {
        try
        {
            jdbcTemplate.update(patientQueries.ADD_PATIENT, patient.getName(), patient.getGender().toString(), patient.getAddress(), patient.getCnp());

            logger.info("Patient added successfully!");
            Patient pat = jdbcTemplate.queryForObject(patientQueries.GET_PATIENT_BY_CNP, new Object[]{patient.getCnp()}, (rs,rowNum) ->
                    new Patient(
                            rs.getInt("patientid"),
                            rs.getString("name"),
                            Gender.valueOf(rs.getString("gender")),
                            rs.getString("address"),
                            rs.getString("cnp")
                    ));
            return pat;
        }
        catch(Exception e)
        {
            logger.error(e.getMessage());
            throw new Exception("Could not insert patient into database." + e.getMessage());
        }
    }

    public List<Patient> getAllPatients() throws Exception {
        try
        {
            List<Patient> allPatients = jdbcTemplate.query(patientQueries.GET_ALL,
                    (rs,rowNum) -> new Patient(
                            rs.getInt("patientid"),
                            rs.getString("name"),
                            Gender.valueOf(rs.getString("gender")),
                            rs.getString("address"),
                            rs.getString("cnp")
                    ));
            logger.info("Successfully received all patients from database!");
            return allPatients;
        }
        catch(Exception ex)
        {
            logger.error(ex.getMessage());
            throw new Exception("Could not extract all patients from database." + ex.getMessage());
        }
    }

    public Patient getPatientByName(String name) throws Exception {
        try
        {
            Patient pat = jdbcTemplate.queryForObject(patientQueries.GET_PATIENT_BY_NAME, new Object[]{name}, (rs,rowNum) ->
                    new Patient(
                            rs.getInt("patientid"),
                            rs.getString("name"),
                            Gender.valueOf(rs.getString("gender")),
                            rs.getString("address"),
                            rs.getString("cnp")
                    ));
            if(pat == null)
            {
                logger.error("Patient not found");
                throw new ObjectNotFoundException("Patient was not found.");
            }
            logger.info("Successfully retrieved patient from database!");
            return pat;
        }
        catch(Exception exception)
        {
            logger.error(exception.getMessage());
            throw new Exception("Could not extract patient from database." + exception.getMessage());
        }
    }

    @Override
    public Patient getPatientByCNP(String cnp) throws Exception {
        try
        {
            Patient pat = jdbcTemplate.queryForObject(patientQueries.GET_PATIENT_BY_CNP, new Object[]{cnp}, (rs,rowNum) ->
                    new Patient(
                            rs.getInt("patientid"),
                            rs.getString("name"),
                            Gender.valueOf(rs.getString("gender")),
                            rs.getString("address"),
                            rs.getString("cnp")
                    ));
            if(pat == null)
            {
                logger.error("Patient not found");
                throw new ObjectNotFoundException("Patient was not found.");
            }
            logger.info("Successfully retrieved patient from database!");
            return pat;
        }
        catch(Exception exception)
        {
            logger.error(exception.getMessage());
            throw new Exception("Could not extract patient from database." + exception.getMessage());
        }
    }

    @Override
    public Patient updatePatient(Patient patient) throws Exception {
        try
        {
            jdbcTemplate.update(patientQueries.UPDATE_PATIENT, patient.getName(), patient.getGender().toString(), patient.getAddress(), patient.getCnp());
            logger.info("Patient information successfully updated!");
            Patient pat = jdbcTemplate.queryForObject(patientQueries.GET_PATIENT_BY_CNP, new Object[]{patient.getCnp()}, (rs,rowNum) ->
                    new Patient(
                            rs.getInt("patientid"),
                            rs.getString("name"),
                            Gender.valueOf(rs.getString("gender")),
                            rs.getString("address"),
                            rs.getString("cnp")
                    ));
            return pat;
        }
        catch(Exception exception)
        {
            logger.error(exception.getMessage());
            throw new Exception("Could not update patient information." + exception.getMessage());
        }
    }

    @Override
    public boolean deletePatient(int id) throws Exception {
        try
        {
            jdbcTemplate.update(patientQueries.DELETE_PATIENT, id);
            logger.info("Successfully deleted patient!");
            return true;
        }
        catch(Exception exception)
        {
            logger.error(exception.getMessage());
            throw new Exception("Could not delete patient." + exception.getMessage());
        }
    }
}
