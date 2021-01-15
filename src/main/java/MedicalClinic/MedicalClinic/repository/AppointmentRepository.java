package MedicalClinic.MedicalClinic.repository;

import MedicalClinic.MedicalClinic.Queries.AppointmentQueries;
import MedicalClinic.MedicalClinic.model.Appointment;
import MedicalClinic.MedicalClinic.utils.MyLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public class AppointmentRepository implements IAppointmentRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private AppointmentQueries appointmentQueries;
    @Autowired
    private MyLogger logger;

    @Override
    public Appointment addAppointment(Appointment appointment) throws Exception {
        try
        {
            GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(Connection -> {
                PreparedStatement ps = Connection.prepareStatement(appointmentQueries.ADD_APPOINTMENT, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1,appointment.getDoctorId());
                ps.setInt(2,appointment.getPatientId());
                ps.setTimestamp(3, new Timestamp(appointment.getDate().getTime()));
                return ps;
            }, generatedKeyHolder);
            logger.info("Appointment added successfully!");
            Appointment app = jdbcTemplate.queryForObject(appointmentQueries.GET_APPOINTMENT, new Object[]{generatedKeyHolder.getKey().intValue()}, (rs, rowNum) ->
                    new Appointment(
                            rs.getInt("appointmentid"),
                            rs.getInt("doctorid"),
                            rs.getInt("patientid"),
                            new Date(rs.getTimestamp("date").getTime())));
            return app;
        }
        catch(Exception e)
        {
            logger.error(e.getMessage());
            throw new Exception("Could not insert appointment into database." + e.getMessage());
        }
    }

    @Override
    public List<Appointment> getAllAppointmentsByDoctor(int doctorId) throws Exception {
        try
        {
            List<Appointment> app = jdbcTemplate.query(appointmentQueries.GET_ALL_BY_DOCTOR, new Object[]{doctorId}, (rs,rowNum) ->
                new Appointment(
                        rs.getInt("appointmentid"),
                        rs.getInt("doctorid"),
                        rs.getInt("patientid"),
                        new Date(rs.getTimestamp("date").getTime())
                ));
            logger.info("Successfully retrieved appointment from database!");
            return app;

        }
        catch(Exception ex)
        {
            logger.error(ex.getMessage());
            throw new Exception("Could not get appointment from database." + ex.getMessage());
        }

    }

    @Override
    public List<Appointment> getAllAppointmentsByPatient(int patientId) throws Exception {
        try
        {
            List<Appointment> app = jdbcTemplate.query(appointmentQueries.GET_ALL_BY_PATIENT, new Object[]{patientId}, (rs,rowNum) ->
                    new Appointment(
                            rs.getInt("appointmentid"),
                            rs.getInt("doctorid"),
                            rs.getInt("patientid"),
                            new Date(rs.getTimestamp("date").getTime())
                    ));
            logger.info("Successfully retrieved appointment from database!");
            return app;

        }
        catch(Exception ex)
        {
            logger.error(ex.getMessage());
            throw new Exception("Could not get appointment from database." + ex.getMessage());
        }
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) throws Exception {
        try
        {
            jdbcTemplate.update(appointmentQueries.UPDATE_APPOINTMENT, appointment.getDoctorId(), new Timestamp(appointment.getDate().getTime()), appointment.getAppointmentId());
            logger.info("Appointment added successfully!");
            Appointment app = jdbcTemplate.queryForObject(appointmentQueries.GET_APPOINTMENT,new Object[]{appointment.getAppointmentId()}, (rs, rowNum) ->
                    new Appointment(
                            rs.getInt("appointmentid"),
                            rs.getInt("doctorid"),
                            rs.getInt("patientid"),
                            new Date(rs.getTimestamp("date").getTime())));
            return app;
        }
        catch(Exception e)
        {
            logger.error(e.getMessage());
            throw new Exception("Could not update appointment into database." + e.getMessage());
        }
    }

    @Override
    public boolean deleteAppointment(int appointmentId) throws Exception {
        try
        {
            jdbcTemplate.update(appointmentQueries.DELETE_APPOINTMENT, appointmentId);
            logger.info("Appointment was successfully deleted!");
            return true;
        }
        catch(Exception exception)
        {
            logger.error(exception.getMessage());
            throw new Exception("Could not delete appointment." + exception.getMessage());
        }
    }
}
