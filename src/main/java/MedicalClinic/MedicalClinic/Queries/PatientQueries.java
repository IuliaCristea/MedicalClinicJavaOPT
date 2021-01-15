package MedicalClinic.MedicalClinic.Queries;

public class PatientQueries {

    public static final String ADD_PATIENT = "insert into medicalclinic.patient (name, gender, address, cnp) values (?, ?, ?, ?)";
    public static final String GET_ALL = "select * FROM medicalclinic.patient";
    public static final String GET_PATIENT_BY_NAME = "select * from medicalclinic.patient where name = ?";
    public static final String GET_PATIENT_BY_CNP = "select * from medicalclinic.patient where cnp = ?";
    public static final String UPDATE_PATIENT = "update medicalclinic.patient set name=?, gender=?,address=? where cnp = ?";
    public static final String DELETE_PATIENT = "delete from medicalclinic.patient where patientid = ?";
}
