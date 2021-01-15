package MedicalClinic.MedicalClinic.Queries;

public class DoctorQueries {
    public static final String ADD_DOCTOR = "insert into medicalclinic.doctor (name, gender, specialty, clinicid) values (?, ?, ?,?)";
    public static final String GET_ALL_DOCTORS_BY_CLINIC = "select * from medicalclinic.doctor where clinicid = ?";
    public static final String GET_ALL_DOCTORS_BY_SPECIALTY = "select * from medicalclinic.doctor where specialty = ?";
    public static final String GET_ALL_DOCTORS_BY_CLINIC_AND_SPECIALTY = "select * from medicalclinic.doctor where clinicid = ? and specialty = ?";
    public static final String GET_DOCTOR_BY_NAME = "select * from medicalclinic.doctor where name = ?";
    public static final String UPDATE_DOCTOR = "update medicalclinic.doctor set gender=?,specialty=?, clinicid = ? where name = ?";
    public static final String DELETE_DOCTOR = "delete from medicalclinic.doctor where doctorid = ?";
}
