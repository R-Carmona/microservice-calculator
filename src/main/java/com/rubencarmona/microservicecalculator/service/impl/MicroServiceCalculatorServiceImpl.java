package com.rubencarmona.microservicecalculator.service.impl;

import com.rubencarmona.microservicecalculator.domain.Operation;
import com.rubencarmona.microservicecalculator.domain.dto.OperationDTO;
import com.rubencarmona.microservicecalculator.domain.dto.OperationResultDTO;
import com.rubencarmona.microservicecalculator.service.MicroServiceCalculatorService;
import io.corp.calculator.TracerImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.logging.Logger;

/**
 * Clase de servicio con la lógica de la realización de las operaciones.
 */
@Service
@AllArgsConstructor
@NoArgsConstructor
public class MicroServiceCalculatorServiceImpl implements MicroServiceCalculatorService {

    TracerImpl tracer;
    private final Logger LOGGER = Logger.getLogger(MicroServiceCalculatorServiceImpl.class.getName());


    /**
     * Método que realiza las operaciones.
     * @param operationDTO datos de la operación.
     * @return OperationResultDTO el resultado de la operación.
     */
    @Override
    public OperationResultDTO getOperation(OperationDTO operationDTO) {

        LOGGER.info("Walking through the MicroServiceCalculatorServiceImpl: " + LOGGER.getName());

        Operation operation = Operation.builder().firstOperator(operationDTO.getFirstOperator())
                .secondOperator(operationDTO.getSecondOperator())
                .operator(operationDTO.getOperator()).build();

        BigDecimal firstOperator = operation.getFirstOperator();
        BigDecimal secondOperator = operation.getSecondOperator();
        BigDecimal result = BigDecimal.ZERO;

        /**
         * Realizamos las operaciones permitidas.
         * Para actualizar el microservicio con más operaciones se deberán de añadir a los
         * casos posteriores, junto al método {@link com.rubencarmona.microservicecalculator.controller#validator(operationDTO)}
         */
        switch (operation.getOperator()){
            case "+":
                result = firstOperator.add(secondOperator);
                break;
            case "-":
                result = firstOperator.subtract(secondOperator);
                break;
        };

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
