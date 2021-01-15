package MedicalClinic.MedicalClinic.controller;

import MedicalClinic.MedicalClinic.model.Patient;
import MedicalClinic.MedicalClinic.service.IPatientService;
import MedicalClinic.MedicalClinic.utils.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private IPatientService patientService;

    @GetMapping("/test")
    public String Test()
    {
        return "test";
    }
    @PostMapping("/add")
    public ResponseEntity<?> addNewPatient(@RequestBody @Valid Patient patient)
    {
        try
        {
            return ResponseEntity.ok().body(patientService.addPatient(patient));
        }
        catch(Exception exception)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not add patient. " + exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPatients()
    {
        try
        {
            return ResponseEntity.ok().body(patientService.getAllPatients());
        }
        catch(ObjectNotFoundException exception)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/byName")
    public ResponseEntity<?> getPatientByName(@RequestParam (name = "name") String name) throws Exception {
        try
        {
            return ResponseEntity.ok().body(patientService.getPatientByName(name));
        }

        catch(ObjectNotFoundException exception)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }

    }

    @GetMapping("/byCNP")
    public ResponseEntity<?> getPatientByCNP(@RequestParam String cnp)
    {
        try
        {
            return ResponseEntity.ok().body(patientService.getPatientByCNP(cnp));
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
    public ResponseEntity<?> updatePatient(@RequestBody @Valid Patient patient)
    {
        try
        {
            return ResponseEntity.ok().body(patientService.updatePatient(patient));
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
    public ResponseEntity<?> deletePatient(@RequestParam int id)
    {
        try
        {
            return ResponseEntity.ok().body(patientService.deletePatient(id));
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
