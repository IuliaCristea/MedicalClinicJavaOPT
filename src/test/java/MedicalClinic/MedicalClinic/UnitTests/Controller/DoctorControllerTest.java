package MedicalClinic.MedicalClinic.UnitTests.Controller;

import MedicalClinic.MedicalClinic.controller.DoctorController;
import MedicalClinic.MedicalClinic.model.Doctor;
import MedicalClinic.MedicalClinic.service.DoctorService;
import MedicalClinic.MedicalClinic.utils.Gender;
import MedicalClinic.MedicalClinic.utils.Specialty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DoctorControllerTest {

    @InjectMocks
    private DoctorController doctorController;

    @Mock
    private DoctorService doctorService;

    @BeforeEach
    public void beforeEach(){
        System.out.println("Start executing unit test for doctor controller...");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Starting executing unit tests for doctor controller...");
    }

    @AfterEach
    public  void afterEach() {
        System.out.println("Done executing unit test for doctor controller.");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Done executing unit tests for doctor controller.");
    }

    @Test
    @DisplayName("Adding a new doctor.")
    public void addDoctorTest() throws Exception {
        //arrange
        Doctor doctor = new Doctor("Test test", Gender.Other, Specialty.AllergyImmunology, 5);
        when(doctorService.addDoctor(doctor)).thenReturn(doctor);

        //act
        ResponseEntity<?> result = doctorController.addNewDoctor(doctor);
        ObjectMapper mapper = new ObjectMapper();
        Doctor doc = mapper.convertValue(result.getBody(), new TypeReference<Doctor>() {});
        //assert
        assertEquals(doctor.getDoctorId(), doc.getDoctorId());
        assertEquals(doctor.getName(), doc.getName());
        assertEquals(doctor.getGender(), doc.getGender());
        assertEquals(doctor.getSpecialty(), doc.getSpecialty());
        assertEquals(doctor.getClinicid(), doc.getClinicid());

        verify(doctorService, times(1)).addDoctor(doctor);
    }

    @Test
    @DisplayName("Retrieving all doctors by clinic.")
    public void getAllDoctorsByClinic() throws Exception {
        //arrange
        int clinicid = 5;
        Doctor doctor = new Doctor("Test test", Gender.Other, Specialty.AllergyImmunology, 5);
        when(doctorService.getAllDoctorsByClinic(clinicid)).thenReturn(
                Arrays.asList(
                        new Doctor("Test test", Gender.Other, Specialty.AllergyImmunology, 5),
                        new Doctor("Test test", Gender.Other, Specialty.AllergyImmunology, 5),
                        new Doctor("Test test", Gender.Other, Specialty.AllergyImmunology, 5)
                )
        );

        //act
        ResponseEntity<?> result = doctorController.getAllDoctorsByClinic(clinicid);
        ObjectMapper mapper = new ObjectMapper();
        List<Doctor> doc = mapper.convertValue(result.getBody(), new TypeReference<List<Doctor>>() {});
        //assert
        assertEquals(doc.size(), 3);
    }
}
