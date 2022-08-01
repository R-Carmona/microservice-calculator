package com.rubencarmona.microservicecalculator.service.impl;

import com.rubencarmona.microservicecalculator.domain.dto.OperationResultDTO;
import com.rubencarmona.microservicecalculator.helpers.DatosHelper;
import com.rubencarmona.microservicecalculator.service.MathOperatorService;
import com.rubencarmona.microservicecalculator.service.MicroServiceCalculatorService;
import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class MicroServiceCalculatorServiceImplTest {
   MicroServiceCalculatorService microServiceCalculatorService;
   TracerImpl tracer;

   @Mock
   ApplicationContext context;
    /**
     * Test del Servicio.
     * El validador de los datos lo tenemos en el controlador, lo que garantizamos
     * que los datos al servicio siempre serán correctos.
     */
    @Test
    void getOperationAddOK() {
        tracer = new TracerImpl();
        microServiceCalculatorService = new MicroServiceCalculatorServiceImpl(tracer,context);

        when(this.context.getBean("+", MathOperatorService.class)).thenReturn(DatosHelper.createMathOperatorAdd());

        OperationResultDTO result = microServiceCalculatorService.getOperation(DatosHelper.createOperation());
        assertThat(result.getOperationResult()).isEqualTo(new BigDecimal(10));
    }

}