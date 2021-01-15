package MedicalClinic.MedicalClinic.Queries;

public class EvaluationQueries {
    public static final String ADD_EVALUATION = "insert into medicalclinic.evaluation (date, diagnostics, observations, appointmentid) values (?, ?, ?,?)";
    public static final String GET_EVALUATION = "select * from medicalclinic.evaluation where evaluationid= ?";
    public static final String GET_ALL_BY_PATIENT = "select ev.evaluationid, ev.appointmentid, ev.date, ev.diagnostics, ev.observations from medicalclinic.evaluation ev join medicalclinic.appointment app on ev.appointmentid=app.appointmentid where app.patientid = ?";
    public static final String GET_ALL_BY_APPOINTMENT = "select * from medicalclinic.evaluation where appointmentid = ?";
    public static final String UPDATE_EVALUATION = "update medicalclinic.evaluation set date = ?, diagnostics = ?, observations = ? where evaluationid = ?";
    public static final String DELETE_EVALUAION = "delete from medicalclinic.evaluation where evaluationid = ?";
}
