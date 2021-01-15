package MedicalClinic.MedicalClinic.controller;

import MedicalClinic.MedicalClinic.model.Appointment;
import MedicalClinic.MedicalClinic.service.IAppointmentService;
import MedicalClinic.MedicalClinic.utils.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private IAppointmentService appointmentService;

    @PostMapping("/add")
    public ResponseEntity<?> addNewAppointment(@RequestBody @Valid Appointment appointment)
    {
        try
        {
            return ResponseEntity.ok().body(appointmentService.addAppointment(appointment));
        }
        catch(Exception exception)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not make an appointment. " + exception.getMessage());
        }
    }

    @GetMapping("/allByDoctor")
    public ResponseEntity<?> getAllAppointmentsByDoctor(@RequestParam int doctorId)
    {
        try
        {
            return ResponseEntity.ok().body(appointmentService.getAllAppointmentsByDoctor(doctorId));
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

    @GetMapping("/allByPatient")
    public ResponseEntity<?> getAllAppointmentsByPatient(@RequestParam int patientId)
    {
        try
        {
            return ResponseEntity.ok().body(appointmentService.getAllAppointmentsByPatient(patientId));
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
    public ResponseEntity<?> updateAppointment(@RequestBody @Valid Appointment appointment)
    {
        try
        {
            return ResponseEntity.ok().body(appointmentService.updateAppointment(appointment));
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
    public ResponseEntity<?> deleteAppointment(@RequestParam int appointmentId)
    {
        try
        {
            return ResponseEntity.ok().body(appointmentService.deleteAppointment(appointmentId));
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
