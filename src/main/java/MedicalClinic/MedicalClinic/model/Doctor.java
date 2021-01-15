package MedicalClinic.MedicalClinic.model;

import MedicalClinic.MedicalClinic.utils.Gender;
import MedicalClinic.MedicalClinic.utils.Specialty;

import javax.validation.constraints.NotNull;

public class Doctor {

    private int doctorId;
    @NotNull(message = "Doctor's name cannot be null.")
    private String name;
    @NotNull(message = "Doctor's gender cannot be null.")
    private Gender gender;
    @NotNull(message = "Doctor's specialty cannot be null.")
    private Specialty specialty;
    @NotNull(message = "Clinic id cannot be null.")
    private int clinicid;

    public Doctor()
    {
        super();
    }
    public Doctor(@NotNull(message = "Doctor's name cannot be null.") String name,
                                @NotNull(message = "Doctor's gender cannot be null.") Gender gender,
                                @NotNull(message = "Doctor's specialty cannot be null.") Specialty specialty,
                                @NotNull(message = "Clinic id cannot be null.") int clinicid) {

        this.name = name;
        this.gender = gender;
        this.specialty = specialty;
        this.clinicid = clinicid;
    }

    public Doctor(int doctorId, @NotNull(message = "Doctor's name cannot be null.") String name,
                  @NotNull(message = "Doctor's gender cannot be null.") Gender gender,
                  @NotNull(message = "Doctor's specialty cannot be null.") Specialty specialty,
                  @NotNull(message = "Clinic id cannot be null.") int clinicid) {
        this.doctorId = doctorId;
        this.name = name;
        this.gender = gender;
        this.specialty = specialty;
        this.clinicid = clinicid;
    }

    public int getClinicid() {
        return clinicid;
    }

    public void setClinicid(int clinicid) {
        this.clinicid = clinicid;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
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

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

}
