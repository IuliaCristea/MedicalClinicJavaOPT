package MedicalClinic.MedicalClinic.service;

import MedicalClinic.MedicalClinic.model.Evaluation;
import MedicalClinic.MedicalClinic.repository.IEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EvaluationService implements IEvaluationService {

    @Autowired
    private IEvaluationRepository evaluationRepository;

    @Override
    public Evaluation addEvaluation(Evaluation evaluation) throws Exception {
        return evaluationRepository.addEvaluation(evaluation);
    }

    @Override
    public List<Evaluation> getAllEvaluationsByPatient(int patientId) throws Exception {
        return evaluationRepository.getAllEvaluationsByPatient(patientId);
    }

    @Override
    public Evaluation getEvaluationByAppointment(int appointmentId) throws Exception {
        return evaluationRepository.getEvaluationByAppointment(appointmentId);
    }

    @Override
    public Evaluation updateEvaluation(Evaluation evaluation) throws Exception {
        return evaluationRepository.updateEvaluation(evaluation);
    }

    @Override
    public boolean deleteEvaluation(int id) throws Exception {
        return evaluationRepository.deleteEvaluation(id);
    }
}
