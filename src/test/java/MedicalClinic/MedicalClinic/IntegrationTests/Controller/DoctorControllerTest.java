package MedicalClinic.MedicalClinic.IntegrationTests.Controller;

import MedicalClinic.MedicalClinic.controller.DoctorController;
import MedicalClinic.MedicalClinic.model.Doctor;
import MedicalClinic.MedicalClinic.service.DoctorService;
import MedicalClinic.MedicalClinic.utils.Gender;
import MedicalClinic.MedicalClinic.utils.Specialty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = DoctorController.class)
public class DoctorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoctorService doctorService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void addNewDoctorTest() throws Exception{
        //arrange
        Doctor doctor = new Doctor("Test test", Gender.Other, Specialty.AllergyImmunology, 5);
        when(doctorService.addDoctor(any())).thenReturn(doctor);

        //act + assert
        mockMvc.perform(
                post("/doctors/add")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(doctor))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(doctor.getName()));
    }

    @Test
    public void getAllDoctorsByClinic() throws Exception{
        //arrange
        Doctor doctor1 =  new Doctor("Test test", Gender.Other, Specialty.AllergyImmunology, 5);
        Doctor doctor2 = new Doctor("Test test", Gender.Other, Specialty.AllergyImmunology, 5);
        List<Doctor> doctors = new ArrayList<Doctor>();
        doctors.add(doctor1);
        doctors.add(doctor2);
        when(doctorService.getAllDoctorsByClinic(anyInt())).thenReturn(doctors);

        //act + assert
        mockMvc.perform(
                get("/doctors/allByClinic")
                        .param("clinicid", "5")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)));
    }
}
