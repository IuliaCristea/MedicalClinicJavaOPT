package MedicalClinic.MedicalClinic.UnitTests.Service;

import MedicalClinic.MedicalClinic.model.Patient;
import MedicalClinic.MedicalClinic.repository.PatientRepository;
import MedicalClinic.MedicalClinic.service.PatientService;
import MedicalClinic.MedicalClinic.utils.Gender;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @InjectMocks
    private PatientService patientService;

    @Mock
    private PatientRepository patientRepository;

    @BeforeEach
    public void beforeEach(){
        System.out.println("Start executing unit test for patient service...");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Starting executing unit tests for patient service...");
    }

    @AfterEach
    public  void afterEach() {
        System.out.println("Done executing unit test for patient service.");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Done executing unit tests for patient service.");
    }

    @Test
    @DisplayName("Adding a new patient.")
    public void addPatientTest() throws Exception {
        //arrange
        Patient patient = new Patient("Mircescu Mircea", Gender.Male, "Cluj, Aleea Mircestilor nr 12, bl 45B, sc 2, ap 32", "2851123542302");
        when(patientRepository.addPatient(patient)).thenReturn(patient);

        //act
        Patient result = patientService.addPatient(patient);

        //assert
        assertEquals(patient.getName(), result.getName());
        assertEquals(patient.getAddress(), result.getAddress());
        assertEquals(patient.getGender(), result.getGender());
        assertEquals(patient.getCnp(), result.getCnp());

        verify(patientRepository, times(1)).addPatient(patient);
    }

    @Test
    @DisplayName("Retrieving a patient by name.")
    public void getPatientByNameTest() throws Exception {
        //arrange
        String name = "Test test";
        when(patientRepository.getPatientByName(name)).thenReturn(
                new Patient("Test test", Gender.Other, "address", "0000000000000")
        );

        //act
        Patient result = patientRepository.getPatientByName(name);

        //assert
        assertEquals(name, result.getName());
    }
}
