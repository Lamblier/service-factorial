package ru.nonoka.servicefactorial.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.nonoka.servicefactorial.model.JsonRequest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FactorialControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper ob;

    @Test
    public void testCalculateFactorial() throws Exception {
        JsonRequest request = new JsonRequest(5l);

        mockMvc.perform(post("/api/v1/calc")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ob.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(120));
    }

    @Test
    public void testCalculateFactorialWithInvalidInput() throws Exception {
        JsonRequest request = new JsonRequest(-1l);

        mockMvc.perform(post("/api/v1/calc")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ob.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Validation failed."));
    }

    @Test
    public void testCalculateFactorialWithInputIsNull() throws Exception {
        mockMvc.perform(post("/api/v1/calc")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ob.writeValueAsString(null)))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.message").value("Internal error"));
    }
}