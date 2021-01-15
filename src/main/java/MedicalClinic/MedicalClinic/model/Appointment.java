package MedicalClinic.MedicalClinic.model;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Appointment {

    private int appointmentId;
    @NotNull(message = "Doctor id could not be null.")
    private int doctorId;
    @NotNull(message = "Patient id could not be null.")
    private int patientId;
    @NotNull(message = "Date could not be null.")
    private Date date;

    public Appointment()
    {
        super();
    }
    public Appointment(@NotNull(message = "Doctor id could not be null.") int doctorId, @NotNull(message = "Patient id could not be null.") int patientId, @NotNull(message = "Date could not be null.") Date date) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.date = date;
    }

    public Appointment(int appointmentId, @NotNull(message = "Doctor id could not be null.") int doctorId, @NotNull(message = "Patient id could not be null.") int patientId, @NotNull(message = "Date could not be null.") Date date) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.date = date;
        this.appointmentId = appointmentId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
