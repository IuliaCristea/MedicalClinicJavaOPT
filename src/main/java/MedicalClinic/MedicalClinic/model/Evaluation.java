package MedicalClinic.MedicalClinic.model;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Evaluation {
    private int evaluationId;
    @NotNull(message = "Appointment id could not be null.")
    private int appointmentId;
    @NotNull(message = "Diagnostic cannot be null.")
    private String diagnostic;
    @NotNull(message = "You need to add observations.")
    private String observations;
    @NotNull(message = "Date cannot be null.")
    private Date date;

    public Evaluation(){
        super();
    }

    public Evaluation(@NotNull(message = "Appointment id could not be null.") int appointmentId,
                    @NotNull(message = "Diagnostic cannot be null.") String diagnostic,
                    @NotNull(message = "You need to add observations.") String observations,
                    @NotNull(message = "Date cannot be null.") Date date) {

        this.appointmentId = appointmentId;
        this.diagnostic = diagnostic;
        this.observations = observations;
        this.date = date;
    }

    public Evaluation(int evaluationId, @NotNull(message = "Appointment id could not be null.") int appointmentId,
                      @NotNull(message = "Diagnostic cannot be null.") String diagnostic,
                      @NotNull(message = "You need to add observations.") String observations,
                      @NotNull(message = "Date cannot be null.") Date date) {
        this.evaluationId = evaluationId;
        this.appointmentId = appointmentId;
        this.diagnostic = diagnostic;
        this.observations = observations;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(int evaluationId) {
        this.evaluationId = evaluationId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
