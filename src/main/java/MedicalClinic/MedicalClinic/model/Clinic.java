package MedicalClinic.MedicalClinic.model;

import javax.validation.constraints.NotNull;

public class Clinic {
    private int clinicId;
    @NotNull(message = "Clinic name could not be null.")
    private String name;
    @NotNull(message = "Clinic address could not be null.")
    private String address;

    public Clinic()
    {

        super();
    }
    public Clinic(@NotNull(message = "Clinic name could not be null.") String name, @NotNull(message = "Clinic address could not be null.") String address) {
        this.name = name;
        this.address = address;
    }

    public Clinic(int clinicId, @NotNull(message = "Clinic name could not be null.") String name, @NotNull(message = "Clinic address could not be null.") String address) {
        this.name = name;
        this.address = address;
        this.clinicId = clinicId;
    }
    public int getClinicId() {
        return clinicId;
    }

    public void setClinicId(int clinicId) {
        this.clinicId = clinicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
