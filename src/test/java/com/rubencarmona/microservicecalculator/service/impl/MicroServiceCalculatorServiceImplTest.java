package com.rubencarmona.microservicecalculator.service.impl;
import com.rubencarmona.microservicecalculator.domain.dto.OperationResultDTO;
import com.rubencarmona.microservicecalculator.helpers.DatosHelper;
import com.rubencarmona.microservicecalculator.service.MicroServiceCalculatorService;
import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MicroServiceCalculatorServiceImplTest {
    MicroServiceCalculatorService microServiceCalculatorService;
   TracerImpl tracer;
    /**
     * Test del Servicio.
     * El validador de los datos lo tenemos en el controlador, lo que garantizamos
     * que los datos al servicio siempre serán correctos.
     */
    @Test
    void getOperationOK() {
        tracer = new TracerImpl();
        microServiceCalculatorService = new MicroServiceCalculatorServiceImpl(tracer);
        OperationResultDTO result = microServiceCalculatorService.getOperation(DatosHelper.createOperation());
        assertThat(result.getOperationResult()).isEqualTo(new BigDecimal(10));
    }

}