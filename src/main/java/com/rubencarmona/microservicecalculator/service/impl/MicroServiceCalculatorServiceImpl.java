package com.rubencarmona.microservicecalculator.service.impl;

import com.rubencarmona.microservicecalculator.controller.MicroServiceCalculatorController;
import com.rubencarmona.microservicecalculator.domain.Operation;
import com.rubencarmona.microservicecalculator.domain.OperationResult;
import com.rubencarmona.microservicecalculator.domain.dto.OperationDTO;
import com.rubencarmona.microservicecalculator.domain.dto.OperationResultDTO;
import com.rubencarmona.microservicecalculator.mapper.OperationMapperService;
import com.rubencarmona.microservicecalculator.service.MicroServiceCalculatorService;
import io.corp.calculator.TracerImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class MicroServiceCalculatorServiceImpl implements MicroServiceCalculatorService {

    TracerImpl tracer = new TracerImpl();
    OperationMapperService operationMapperService;

    private final Logger LOGGER = Logger.getLogger(MicroServiceCalculatorServiceImpl.class.getName());

    @Override
    public OperationResultDTO getOperation(OperationDTO operationDTO) {

        LOGGER.info("Walking through the MicroServiceCalculatorServiceImpl: " + LOGGER.getName());

        Operation operation = Operation.builder().firstOperator(operationDTO.getFirstOperator())
                .secondOperator(operationDTO.getSecondOperator())
                .operator(operationDTO.getOperator()).build();

        BigDecimal firstOperator = operation.getFirstOperator();
        BigDecimal secondOperator = operation.getSecondOperator();
        BigDecimal result = BigDecimal.ZERO;

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


    public void saveTracerResult(OperationResultDTO operationResultDTO) {
        tracer.trace(operationResultDTO);
    };
}// END CLASS
