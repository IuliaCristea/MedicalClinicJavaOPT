package MedicalClinic.MedicalClinic.controller;

import MedicalClinic.MedicalClinic.model.Clinic;
import MedicalClinic.MedicalClinic.service.IClinicService;
import MedicalClinic.MedicalClinic.utils.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/clinics")
public class ClinicController {

    @Autowired
    private IClinicService clinicService;

    @PostMapping("/add")
    public ResponseEntity<?> addNewClinic(@RequestBody @Valid Clinic clinic)
    {
        try
        {
            return ResponseEntity.ok().body(clinicService.addClinic(clinic));
        }
        catch(Exception exception)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not add clinic. " + exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllClinics()
    {
        try
        {
            return ResponseEntity.ok().body(clinicService.getAllClinics());
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

    @GetMapping("/byName")
    public ResponseEntity<?> getClinicByName(@RequestParam String name)
    {
        try
        {
            return ResponseEntity.ok().body(clinicService.getClinicByName(name));
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
    public ResponseEntity<?> updateClinic(@RequestBody @Valid Clinic clinic)
    {
        try
        {
            return ResponseEntity.ok().body(clinicService.updateClinic(clinic));
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
    public ResponseEntity<?> deleteClinic(@RequestParam int id)
    {
        try
        {
            return ResponseEntity.ok().body(clinicService.deleteClinic(id));
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
