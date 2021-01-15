package MedicalClinic.MedicalClinic.repository;

import MedicalClinic.MedicalClinic.Queries.EvaluationQueries;
import MedicalClinic.MedicalClinic.model.Evaluation;
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
public class EvaluationRepository implements IEvaluationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private EvaluationQueries evaluationQueries;
    @Autowired
    private MyLogger logger;

    @Override
    public Evaluation addEvaluation(Evaluation evaluation) throws Exception {
        try
        {
            GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(Connection -> {
                PreparedStatement ps = Connection.prepareStatement(evaluationQueries.ADD_EVALUATION, Statement.RETURN_GENERATED_KEYS);
                ps.setTimestamp(1, new Timestamp(evaluation.getDate().getTime()));
                ps.setString(2,evaluation.getDiagnostic());
                ps.setString(3,evaluation.getObservations());
                ps.setInt(4,evaluation.getAppointmentId());
                return ps;
            }, generatedKeyHolder);
            logger.info("Evaluation added successfully!");
            Evaluation ev = jdbcTemplate.queryForObject(evaluationQueries.GET_EVALUATION, new Object[]{generatedKeyHolder.getKey().intValue()}, (rs, rowNum) ->
                    new Evaluation(
                            rs.getInt("appointmentid"),
                            rs.getString("diagnostics"),
                            rs.getString("observations"),
                            new Date(rs.getTimestamp("date").getTime())));
            ev.setEvaluationId(generatedKeyHolder.getKey().intValue());
            return ev;
        }
        catch(Exception e)
        {
            logger.error(e.getMessage());
            throw new Exception("Could not insert evaluation into database." + e.getMessage());
        }
    }

    @Override
    public List<Evaluation> getAllEvaluationsByPatient(int patientId) throws Exception {
        try
        {
            List<Evaluation> app = jdbcTemplate.query(evaluationQueries.GET_ALL_BY_PATIENT, new Object[]{patientId}, (rs, rowNum) ->
                    new Evaluation(
                            rs.getInt("evaluationid"),
                            rs.getInt("appointmentid"),
                            rs.getString("diagnostics"),
                            rs.getString("observations"),
                            new Date(rs.getTimestamp("date").getTime())));
            logger.info("Successfully retrieved evaluations from database!");
            return app;

        }
        catch(Exception ex)
        {
            logger.error(ex.getMessage());
            throw new Exception("Could not get evaluation from database." + ex.getMessage());
        }
    }

    @Override
    public Evaluation getEvaluationByAppointment(int appointmentId) throws Exception {
        try
        {
            Evaluation app = jdbcTemplate.queryForObject(evaluationQueries.GET_ALL_BY_APPOINTMENT, new Object[]{appointmentId}, (rs, rowNum) ->
                    new Evaluation(
                            rs.getInt("evaluationid"),
                            rs.getInt("appointmentid"),
                            rs.getString("diagnostics"),
                            rs.getString("observations"),
                            new Date(rs.getTimestamp("date").getTime())));
            logger.info("Successfully retrieved evaluations from database!");
            return app;

        }
        catch(Exception ex)
        {
            logger.error(ex.getMessage());
            throw new Exception("Could not get evaluation from database." + ex.getMessage());
        }
    }

    @Override
    public Evaluation updateEvaluation(Evaluation evaluation) throws Exception {
        try
        {
            jdbcTemplate.update(evaluationQueries.UPDATE_EVALUATION, new Timestamp(evaluation.getDate().getTime()), evaluation.getDiagnostic(), evaluation.getObservations(), evaluation.getEvaluationId());
            logger.info("Evaluation updated successfully!");
            Evaluation ev = jdbcTemplate.queryForObject(evaluationQueries.GET_EVALUATION,new Object[]{evaluation.getEvaluationId()}, (rs, rowNum) ->
                    new Evaluation(
                            rs.getInt("evaluationid"),
                            rs.getInt("appointmentid"),
                            rs.getString("diagnostics"),
                            rs.getString("observations"),
                            new Date(rs.getTimestamp("date").getTime())));
            return ev;
        }
        catch(Exception e)
        {
            logger.error(e.getMessage());
            throw new Exception("Could not update evaluation into database." + e.getMessage());
        }
    }

    @Override
    public boolean deleteEvaluation(int id) throws Exception {
        try
        {
            jdbcTemplate.update(evaluationQueries.DELETE_EVALUAION, id);
            logger.info("Evaluation was successfully deleted!");
            return true;
        }
        catch(Exception exception)
        {
            logger.error(exception.getMessage());
            throw new Exception("Could not delete appointment." + exception.getMessage());
        }
    }
}
