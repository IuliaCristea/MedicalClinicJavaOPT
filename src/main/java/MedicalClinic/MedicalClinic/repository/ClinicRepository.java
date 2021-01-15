package MedicalClinic.MedicalClinic.repository;

import MedicalClinic.MedicalClinic.Queries.ClinicQueries;
import MedicalClinic.MedicalClinic.model.Clinic;
import MedicalClinic.MedicalClinic.utils.MyLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClinicRepository implements IClinicRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private ClinicQueries clinicQueriesQueries;
    @Autowired
    private MyLogger logger;

    @Override
    public Clinic addClinic(Clinic clinic) throws Exception {
        try
        {
            jdbcTemplate.update(clinicQueriesQueries.ADD_CLINIC, clinic.getAddress() , clinic.getName());
            logger.info("Clinic added successfully!");
            Clinic cl = jdbcTemplate.queryForObject(clinicQueriesQueries.GET_CLINIC_BY_NAME, new Object[]{clinic.getName()}, (rs, rowNum) ->
                    new Clinic(
                            rs.getInt("clinicid"),
                            rs.getString("name"),
                            rs.getString("address")
                    ));
            return cl;
        }
        catch(Exception e)
        {
            logger.error(e.getMessage());
            throw new Exception("Could not insert clinic into database." + e.getMessage());
        }
    }

    @Override
    public List<Clinic> getAllClinics() throws Exception {
        try
        {
            List<Clinic> allClinics = jdbcTemplate.query(clinicQueriesQueries.GET_ALL,
                    (rs,rowNum) -> new Clinic(
                            rs.getInt("clinicid"),
                            rs.getString("name"),
                            rs.getString("address")
                    ));
            logger.info("Successfully received all clinics from database!");
            return allClinics;
        }
        catch(Exception ex)
        {
            logger.error(ex.getMessage());
            throw new Exception("Could not extract all clinics from database." + ex.getMessage());
        }
    }

    @Override
    public Clinic getClinicByName(String name) throws Exception {
        try
        {
            Clinic clinic = jdbcTemplate.queryForObject(clinicQueriesQueries.GET_CLINIC_BY_NAME, new Object[]{name}, (rs, rowNum) ->
                    new Clinic(
                            rs.getInt("clinicid"),
                            rs.getString("name"),
                            rs.getString("address")
                    ));
            logger.info("Successfully retrieved clinic from database!");
            return clinic;
        }
        catch(Exception exception)
        {
            logger.error(exception.getMessage());
            throw new Exception("Could not extract clinic from database." + exception.getMessage());
        }
    }

    @Override
    public Clinic updateClinic(Clinic clinic) throws Exception {
        try
        {
            jdbcTemplate.update(clinicQueriesQueries.UPDATE_CLINIC,clinic.getAddress(),  clinic.getName());
            logger.info("Clinic information successfully updated!");
            Clinic cl = jdbcTemplate.queryForObject(clinicQueriesQueries.GET_CLINIC_BY_NAME, new Object[]{clinic.getName()}, (rs, rowNum) ->
                    new Clinic(
                            rs.getInt("clinicid"),
                            rs.getString("name"),
                            rs.getString("address")
                    ));
            return cl;
        }
        catch(Exception exception)
        {
            logger.error(exception.getMessage());
            throw new Exception("Could not update clinic information." + exception.getMessage());
        }
    }

    @Override
    public boolean deleteClinic(int id) throws Exception {
        try
        {
            jdbcTemplate.update(clinicQueriesQueries.DELETE_CLINIC, id);
            logger.info("Successfully deleted clinic!");
            return true;
        }
        catch(Exception exception)
        {
            logger.error(exception.getMessage());
            throw new Exception("Could not delete clinic." + exception.getMessage());
        }
    }
}
