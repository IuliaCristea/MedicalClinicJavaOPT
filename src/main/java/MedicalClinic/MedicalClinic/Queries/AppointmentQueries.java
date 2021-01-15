package MedicalClinic.MedicalClinic.Queries;

public class AppointmentQueries {
    public static final String ADD_APPOINTMENT = "insert into medicalclinic.appointment (doctorid, patientid, date) values (?, ?, ?)";
    public static final String GET_APPOINTMENT = "select * from medicalclinic.appointment where appointmentid = ?";
    public static final String GET_ALL_BY_DOCTOR = "select * from medicalclinic.appointment where doctorid = ?";
    public static final String GET_ALL_BY_PATIENT = "select * from medicalclinic.appointment where patientid = ?";
    public static final String UPDATE_APPOINTMENT = "update medicalclinic.appointment set doctorid =?, date = ? where appointmentid = ?";
    public static final String DELETE_APPOINTMENT = "delete from medicalclinic.appointment where appointmentid = ?";
}
