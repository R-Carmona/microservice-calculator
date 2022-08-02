package com.rubencarmona.microservicecalculator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rubencarmona.microservicecalculator.helpers.DatosHelper;
import com.rubencarmona.microservicecalculator.service.MathOperatorService;
import com.rubencarmona.microservicecalculator.service.MicroServiceCalculatorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MicroServiceCalculatorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Mock
    ApplicationContext context;

    @Mock
    MicroServiceCalculatorService mockMicroServiceCalculatorService;

    @Mock
    MicroServiceCalculatorController mockMicroServiceCalculatorController;

    @Test
    void controllerOKTest() throws Exception {

        mockMicroServiceCalculatorService.getOperation(DatosHelper.createOperation());
        mockMicroServiceCalculatorController.validator(DatosHelper.createOperation());

        when(this.context.getBean("+", MathOperatorService.class)).thenReturn(DatosHelper.createMathOperatorAdd());

        mockMvc
                .perform(
                        post("/api/operation")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(DatosHelper.createOperation())))
                .andDo(print())
                .andExpect(status().isOk());
        verify(mockMicroServiceCalculatorService).getOperation(DatosHelper.createOperation());
        verify(mockMicroServiceCalculatorService, times(1)).getOperation(DatosHelper.createOperation());
        verify(mockMicroServiceCalculatorController, times(1)).validator(DatosHelper.createOperation());
    }

    @Test
    void controllerNokOKTest() throws Exception {
        verify(mockMicroServiceCalculatorService, never()).getOperation(DatosHelper.createOperation());
        verifyNoInteractions(mockMicroServiceCalculatorService);
        mockMvc
                .perform(
                        post("/api/operation")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString("NOK")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void controllerNokOKTestFirstOperator() throws Exception {
        verify(mockMicroServiceCalculatorService, never()).getOperation(DatosHelper.createOperation());
        verifyNoInteractions(mockMicroServiceCalculatorService);
        mockMvc
                .perform(
                        post("/api/operation")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(DatosHelper.createOperationFirstOperatorNULL())))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void controllerNokOKTestSecondOperator() throws Exception {
        verify(mockMicroServiceCalculatorService, never()).getOperation(DatosHelper.createOperation());
        verifyNoInteractions(mockMicroServiceCalculatorService);
        mockMvc
                .perform(
                        post("/api/operation")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(DatosHelper.createOperationSecondOperatorNULL())))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void controllerNokOKTestOperator() throws Exception {
        verify(mockMicroServiceCalculatorService, never()).getOperation(DatosHelper.createOperation());
        verifyNoInteractions(mockMicroServiceCalculatorService);
        mockMvc
                .perform(
                        post("/api/operation")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(DatosHelper.createOperationFaultOperator())))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
