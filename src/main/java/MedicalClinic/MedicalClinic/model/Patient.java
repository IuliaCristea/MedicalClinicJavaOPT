package MedicalClinic.MedicalClinic.model;
import MedicalClinic.MedicalClinic.utils.Gender;

import javax.validation.constraints.NotNull;

public class Patient {

    private int patientId;
    @NotNull(message = "Patient's name cannot be null.")
    private String name;
    @NotNull(message = "Patient's gender cannot be null.")
    private Gender gender;
    @NotNull(message = "Patient's address cannot be null.")
    private String address;
    @NotNull(message = "Patient's cnp cannot be null.")
    private String cnp;

    public Patient()
    {
        super();
    }
    public Patient(String name, Gender gender, String address, String cnp) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.cnp = cnp;

    }

    public Patient(int patientId, String name, Gender gender, String address, String cnp) {
        this.patientId = patientId;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.cnp = cnp;

    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }
}
