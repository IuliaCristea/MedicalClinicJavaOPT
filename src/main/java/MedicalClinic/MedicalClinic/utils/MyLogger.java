package MedicalClinic.MedicalClinic.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;

@Repository
public class MyLogger {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String LOG = "insert into medicalclinic.logger (message, date) values (?,?)";

    public void info(String message)
    {
        jdbcTemplate.update(LOG, message, new Timestamp((new Date()).getTime()));
    }
    public void error(String message)
    {
        jdbcTemplate.update(LOG, message, new Timestamp((new Date()).getTime()));
    }
}
