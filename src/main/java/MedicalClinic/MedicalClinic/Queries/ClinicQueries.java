package MedicalClinic.MedicalClinic.Queries;

public class ClinicQueries {
    public static final String ADD_CLINIC = "insert into medicalclinic.clinic (address, name) values (?, ?)";
    public static final String GET_ALL = "select * from medicalclinic.clinic";
    public static final String GET_CLINIC_BY_NAME = "select * from medicalclinic.clinic where name = ?";
    public static final String UPDATE_CLINIC = "update medicalclinic.clinic set address=? where name = ?";
    public static final String DELETE_CLINIC = "delete from medicalclinic.clinic where clinicid = ?";
}
