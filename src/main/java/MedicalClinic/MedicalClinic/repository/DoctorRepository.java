package MedicalClinic.MedicalClinic.repository;

import MedicalClinic.MedicalClinic.Queries.DoctorQueries;
import MedicalClinic.MedicalClinic.model.Doctor;
import MedicalClinic.MedicalClinic.utils.Gender;
import MedicalClinic.MedicalClinic.utils.MyLogger;
import MedicalClinic.MedicalClinic.utils.Specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorRepository implements IDoctorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private DoctorQueries doctorQueries;
    @Autowired
    private MyLogger logger;

    @Override
    public Doctor addDoctor(Doctor doctor) throws Exception {
        try
        {
            jdbcTemplate.update(doctorQueries.ADD_DOCTOR, doctor.getName(), doctor.getGender().toString(), doctor.getSpecialty().toString(), doctor.getClinicid());
            logger.info("Doctor added successfully!");
            Doctor doc = jdbcTemplate.queryForObject(doctorQueries.GET_DOCTOR_BY_NAME, new Object[]{doctor.getName()}, (rs, rowNum) ->
                    new Doctor(
                            rs.getInt("doctorid"),
                            rs.getString("name"),
                            Gender.valueOf(rs.getString("gender")),
                            Specialty.valueOf(rs.getString("specialty")),
                            rs.getInt("clinicid")));
            return doc;
        }
        catch(Exception e)
        {
            logger.error(e.getMessage());
            throw new Exception("Could not insert doctor into database." + e.getMessage());
        }
    }

    @Override
    public List<Doctor> getAllDoctorsByClinic(int clinicid) throws Exception {
        try
        {
            List<Doctor> doc = jdbcTemplate.query(doctorQueries.GET_ALL_DOCTORS_BY_CLINIC, new Object[]{clinicid}, (rs, rowNum) ->
                    new Doctor(
                            rs.getInt("doctorid"),
                            rs.getString("name"),
                            Gender.valueOf(rs.getString("gender")),
                            Specialty.valueOf(rs.getString("specialty")),
                            clinicid));
            logger.info("Successfully retrieved doctors from database!");
            return doc;
        }
        catch(Exception exception)
        {
            logger.error(exception.getMessage());
            throw new Exception("Could not extract doctor from database." + exception.getMessage());
        }
    }

    @Override
    public List<Doctor> getAllDoctorsBySpecialty(String specialty) throws Exception {
        try
        {
            List<Doctor> doc = jdbcTemplate.query(doctorQueries.GET_ALL_DOCTORS_BY_SPECIALTY, new Object[]{specialty.toString()}, (rs, rowNum) ->
                    new Doctor(
                            rs.getInt("doctorid"),
                            rs.getString("name"),
                            Gender.valueOf(rs.getString("gender")),
                            Specialty.valueOf(rs.getString("specialty")),
                            rs.getInt("clinicid")));
            logger.info("Successfully retrieved doctors from database!");
            return doc;
        }
        catch(Exception exception)
        {
            logger.error(exception.getMessage());
            throw new Exception("Could not extract doctor from database." + exception.getMessage());
        }
    }

    @Override
    public List<Doctor> getAllDoctorsByClinicAndSpecialty(int clinicId, String specialty) throws Exception {
        try
        {
            List<Doctor> doc = jdbcTemplate.query(doctorQueries.GET_ALL_DOCTORS_BY_CLINIC_AND_SPECIALTY, new Object[]{clinicId, specialty}, (rs, rowNum) ->
                    new Doctor(
                            rs.getInt("doctorid"),
                            rs.getString("name"),
                            Gender.valueOf(rs.getString("gender")),
                            Specialty.valueOf(rs.getString("specialty")),
                            rs.getInt("clinicid")));
            logger.info("Successfully retrieved doctors from database!");
            return doc;
        }
        catch(Exception exception)
        {
            logger.error(exception.getMessage());
            throw new Exception("Could not extract doctor from database." + exception.getMessage());
        }
    }

    @Override
    public Doctor getDoctorByName(String name) throws Exception {
        try
        {
            Doctor doc = jdbcTemplate.queryForObject(doctorQueries.GET_DOCTOR_BY_NAME, new Object[]{name}, (rs, rowNum) ->
                    new Doctor(
                            rs.getInt("doctorid"),
                            rs.getString("name"),
                            Gender.valueOf(rs.getString("gender")),
                            Specialty.valueOf(rs.getString("specialty")),
                            rs.getInt("clinicid")));
            logger.info("Successfully retrieved doctor from database!");
            return doc;
        }
        catch(Exception exception)
        {
            logger.error(exception.getMessage());
            throw new Exception("Could not extract doctor from database." + exception.getMessage());
        }
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) throws Exception {
        try
        {
            jdbcTemplate.update(doctorQueries.UPDATE_DOCTOR, doctor.getGender().toString(), doctor.getSpecialty().toString(), doctor.getClinicid() , doctor.getName());
            logger.info("Doctor information successfully updated!");
            Doctor doc = jdbcTemplate.queryForObject(doctorQueries.GET_DOCTOR_BY_NAME, new Object[]{doctor.getName()}, (rs, rowNum) ->
                    new Doctor(
                            rs.getInt("doctorid"),
                            rs.getString("name"),
                            Gender.valueOf(rs.getString("gender")),
                            Specialty.valueOf(rs.getString("specialty")),
                            rs.getInt("clinicid")));
            return doc;
        }
        catch(Exception exception)
        {
            logger.error(exception.getMessage());
            throw new Exception("Could not update doctor information." + exception.getMessage());
        }
    }

    @Override
    public boolean deleteDoctor(int id) throws Exception {
        try
        {
            var response =  jdbcTemplate.update(doctorQueries.DELETE_DOCTOR, id);
            if(response == 1)
            {
                logger.info("Successfully deleted doctor!");
                return true;
            }
            else
            {
                logger.info("There was no doctor with that identifier.");
                return false;
            }
        }
        catch(Exception exception)
        {
            logger.error(exception.getMessage());
            throw new Exception("Could not delete doctor." + exception.getMessage());
        }
    }
}
