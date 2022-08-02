package com.rubencarmona.microservicecalculator.service.impl;

import com.rubencarmona.microservicecalculator.domain.Operation;
import com.rubencarmona.microservicecalculator.domain.dto.OperationDTO;
import com.rubencarmona.microservicecalculator.domain.dto.OperationResultDTO;
import com.rubencarmona.microservicecalculator.service.MathOperatorService;
import com.rubencarmona.microservicecalculator.service.MicroServiceCalculatorService;
import io.corp.calculator.TracerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.logging.Logger;
/**
 * Clase de servicio con la lógica de la realización de las operaciones.
 */
@Service
@RequiredArgsConstructor
public class MicroServiceCalculatorServiceImpl implements MicroServiceCalculatorService {

    private final TracerImpl tracer;
    private static final Logger LOGGER = Logger.getLogger(MicroServiceCalculatorServiceImpl.class.getName());

    private final ApplicationContext context;

    /**
     * Método que realiza las operaciones.
     * @param operationDTO datos de la operación.
     * @return OperationResultDTO el resultado de la operación.
     */
    @Override
    public OperationResultDTO getOperation(OperationDTO operationDTO) {

        /**
         * Añadimos un componente obtenido del contexto de la aplicación, el cual llamará a su clase correcta
         * referenciando el signo del operador obtenido en la llamada, para añadir más operaciones solo habrá
         * que implementar la interfaz MathOperator y la lógica de la operación que queremos realizar.
         */
        MathOperatorService mathOperatorService = this.context.getBean(operationDTO.getOperator(), MathOperatorService.class);

        LOGGER.info("Walking through the MicroServiceCalculatorServiceImpl: " + LOGGER.getName());

        Operation operation = Operation.builder().firstOperator(operationDTO.getFirstOperator())
                .secondOperator(operationDTO.getSecondOperator())
                .operator(operationDTO.getOperator()).build();

        BigDecimal firstOperator = operation.getFirstOperator();
        BigDecimal secondOperator = operation.getSecondOperator();
        BigDecimal result = mathOperatorService.operator(firstOperator,secondOperator);

        OperationResultDTO operationResultDTO = OperationResultDTO.builder().operationResult(result).build();
        saveTracerResult(operationResultDTO);
        return operationResultDTO;

    }// END METHOD

    /**
     * Método para guardar los datos de la trazabilidad de las operaciones.
     * @param operationResultDTO
     */
    public void saveTracerResult(OperationResultDTO operationResultDTO) {
        tracer.trace(operationResultDTO);
    };

}// END CLASS
