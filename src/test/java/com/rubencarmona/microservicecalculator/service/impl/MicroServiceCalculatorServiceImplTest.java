package com.rubencarmona.microservicecalculator.service.impl;

import com.rubencarmona.microservicecalculator.helpers.DatosHelper;
import com.rubencarmona.microservicecalculator.service.MicroServiceCalculatorService;
import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class MicroServiceCalculatorServiceImplTest {

    @MockBean private MicroServiceCalculatorService microServiceCalculatorService;


    @Test
    void getOperationOK() {
        when(microServiceCalculatorService.getOperation(DatosHelper.createOperation())).thenReturn(DatosHelper.createResult());
    }

}