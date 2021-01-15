package MedicalClinic.MedicalClinic.UnitTests.Service;

import MedicalClinic.MedicalClinic.model.Appointment;
import MedicalClinic.MedicalClinic.repository.AppointmentRepository;
import MedicalClinic.MedicalClinic.service.AppointmentService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppointmentServiceTest {

    @InjectMocks
    private AppointmentService appointmentService;

    @Mock
    private AppointmentRepository appointmentRepository;

    @BeforeEach
    public void beforeEach(){
        System.out.println("Start executing unit test for appointment service...");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Starting executing unit tests for appointment service...");
    }

    @AfterEach
    public  void afterEach() {
        System.out.println("Done executing unit test for appointment service.");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Done executing unit tests for appointment service.");
    }

    @Test
    @DisplayName("Adding a new appointment.")
    public void addAppointmentTest() throws Exception {
        //arrange
        Appointment appointment = new Appointment(8, 6, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse("2021-03-24T15:30"));
        when(appointmentRepository.addAppointment(appointment)).thenReturn(appointment);

        //act
        Appointment result = appointmentService.addAppointment(appointment);

        //assert
        assertEquals(appointment.getDoctorId(), result.getDoctorId());
        assertEquals(appointment.getPatientId(), result.getPatientId());
        assertEquals(appointment.getDate(), result.getDate());

        verify(appointmentRepository, times(1)).addAppointment(appointment);
    }

    @Test
    @DisplayName("Retrieving an appointment by patient id.")
    public void getAllAppointmentsByPatientId() throws Exception {
        //arrange
        int patientid = 6;
        when(appointmentRepository.getAllAppointmentsByPatient(patientid)).thenReturn(
                Arrays.asList(
                        new Appointment(8, 6, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse("2021-03-24T15:30")),
                        new Appointment(8, 6, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse("2021-03-24T15:30")),
                        new Appointment(8, 6, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse("2021-03-24T15:30")),
                        new Appointment(8, 6, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse("2021-03-24T15:30"))
                )
        );

        //act
        List<Appointment> result = appointmentRepository.getAllAppointmentsByPatient(patientid);

        //assert
        assertEquals(result.size(), 4);
    }
}
