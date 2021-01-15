package MedicalClinic.MedicalClinic.IntegrationTests.Service;

import MedicalClinic.MedicalClinic.model.Clinic;
import MedicalClinic.MedicalClinic.service.ClinicService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ClinicServiceTest {
    @Autowired
    private ClinicService clinicService;

    @BeforeEach
    public void tearDown(){
        System.out.println("Should delete any clinic i guess.");
    }
    @Test
    public void addClinicFlowTest() throws Exception {
        Clinic clinic = new Clinic("APACA", "test test");

        Clinic result = clinicService.addClinic(clinic);

        assertNotNull(result.getClinicId());
        assertEquals(clinic.getName(), result.getName());
        assertEquals(clinic.getAddress(), result.getAddress());
    }
}
