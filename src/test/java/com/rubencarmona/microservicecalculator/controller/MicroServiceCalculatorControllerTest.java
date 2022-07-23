package com.rubencarmona.microservicecalculator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rubencarmona.microservicecalculator.helpers.DatosHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MicroServiceCalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void controllerOKTest() throws Exception {
        mockMvc
                .perform(
                        post("/api/operation")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(DatosHelper.createOperation())))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void controllerNokOKTest() throws Exception {
        mockMvc
                .perform(
                        post("/api/operation")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString("NOK")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
