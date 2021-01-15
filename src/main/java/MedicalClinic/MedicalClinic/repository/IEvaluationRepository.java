package MedicalClinic.MedicalClinic.repository;

import MedicalClinic.MedicalClinic.model.Evaluation;

import java.util.List;

public interface IEvaluationRepository {
    Evaluation addEvaluation(Evaluation evaluation) throws Exception;
    List<Evaluation> getAllEvaluationsByPatient(int patientId) throws Exception;
    Evaluation getEvaluationByAppointment(int appointmentId) throws Exception;
    Evaluation updateEvaluation(Evaluation evaluation) throws Exception;
    boolean deleteEvaluation(int id) throws Exception;
}
