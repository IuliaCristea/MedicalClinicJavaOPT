package MedicalClinic.MedicalClinic.controller;

import MedicalClinic.MedicalClinic.model.Evaluation;
import MedicalClinic.MedicalClinic.service.IEvaluationService;
import MedicalClinic.MedicalClinic.utils.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/evaluations")
public class EvaluationController {

    @Autowired
    private IEvaluationService evaluationService;

    @PostMapping("/add")
    public ResponseEntity<?> addNewEvaluation(@RequestBody @Valid Evaluation evaluation)
    {
        try
        {
            return ResponseEntity.ok().body(evaluationService.addEvaluation(evaluation));
        }
        catch(Exception exception)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not add an evaluation. " + exception.getMessage());
        }
    }

    @GetMapping("/allByPatient")
    public ResponseEntity<?> getAllEvaluationsByPatient(@RequestParam int patientId)
    {
        try
        {
            return ResponseEntity.ok().body(evaluationService.getAllEvaluationsByPatient(patientId));
        }
        catch(ObjectNotFoundException exception)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
        catch(Exception exception)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("/ByAppointment")
    public ResponseEntity<?> getEvaluationByAppointment(@RequestParam int appointmentId)
    {
        try
        {
            return ResponseEntity.ok().body(evaluationService.getEvaluationByAppointment(appointmentId));
        }
        catch(ObjectNotFoundException exception)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
        catch(Exception exception)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateEvaluation(@RequestBody @Valid Evaluation evaluation)
    {
        try
        {
            return ResponseEntity.ok().body(evaluationService.updateEvaluation(evaluation));
        }
        catch(ObjectNotFoundException exception)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
        catch(Exception exception)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEvaluation(@RequestParam int id)
    {
        try
        {
            return ResponseEntity.ok().body(evaluationService.deleteEvaluation(id));
        }
        catch (ObjectNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
