package MedicalClinic.MedicalClinic.controller;

import MedicalClinic.MedicalClinic.model.Doctor;
import MedicalClinic.MedicalClinic.service.IDoctorService;
import MedicalClinic.MedicalClinic.utils.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static MedicalClinic.MedicalClinic.utils.Specialty.isValid;


@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private IDoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity<?> addNewDoctor(@RequestBody @Valid Doctor doctor )
    {
        try
        {
            return ResponseEntity.ok().body(doctorService.addDoctor(doctor));
        }
        catch(Exception exception)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not add doctor. " + exception.getMessage());
        }
    }

    @GetMapping("/allByClinic")
    public ResponseEntity<?> getAllDoctorsByClinic(@RequestParam int clinicid)
    {
        try
        {
            return ResponseEntity.ok().body(doctorService.getAllDoctorsByClinic(clinicid));
        }
        catch(ObjectNotFoundException exception)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
        catch(Exception exception)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not get doctor. " + exception.getMessage());
        }
    }

    @GetMapping("/allBySpecialty")
    public ResponseEntity<?> getAllDoctorsBySpecialty(@RequestParam String specialty)
    {

        if(!isValid(specialty))
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid specialty.");
        }


        try
        {
            return ResponseEntity.ok().body(doctorService.getAllDoctorsBySpecialty(specialty));
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

    @GetMapping("/allByClinicAndSpecialty")
    public ResponseEntity<?> getAllDoctorsByClinicAndSpecialty(@RequestParam int clinicId, @RequestParam String specialty)
    {

        if(!isValid(specialty))
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid specialty.");
        }


        try
        {
            return ResponseEntity.ok().body(doctorService.getAllDoctorsByClinicAndSpecialty(clinicId,specialty));
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
    public ResponseEntity<?> getDoctorByName(@RequestParam String name)
    {
        try
        {
            return ResponseEntity.ok().body(doctorService.getDoctorByName(name));
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
    public ResponseEntity<?> updateDoctor(@RequestBody @Valid Doctor doctor)
    {
        try
        {
            return ResponseEntity.ok().body(doctorService.updateDoctor(doctor));
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
    public ResponseEntity<?> deleteDoctor(@RequestParam int id)
    {
        try
        {
            return ResponseEntity.ok().body(doctorService.deleteDoctor(id));
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
