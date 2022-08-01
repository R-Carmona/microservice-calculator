package com.rubencarmona.microservicecalculator.helpers;

import com.rubencarmona.microservicecalculator.domain.dto.OperationDTO;
import com.rubencarmona.microservicecalculator.domain.dto.OperationResultDTO;
import com.rubencarmona.microservicecalculator.service.MathOperatorService;
import com.rubencarmona.microservicecalculator.service.impl.MathOperatorServiceAddImpl;
import com.rubencarmona.microservicecalculator.service.impl.MathOperatorServiceSubImpl;

import java.math.BigDecimal;

public class DatosHelper {

    public static OperationDTO createOperation() {
       return OperationDTO.builder().firstOperator(new BigDecimal(5.0)).secondOperator(new BigDecimal(5.0)).operator("+").build();
    }

    public static OperationResultDTO createResult() {
        return OperationResultDTO.builder().operationResult(new BigDecimal(10.0)).build();
    }

    public static OperationDTO createOperationFirstOperatorNULL() {
        return OperationDTO.builder().firstOperator(null).secondOperator(new BigDecimal(5.0)).operator("+").build();
    }

    public static OperationDTO createOperationSecondOperatorNULL() {
        return OperationDTO.builder().firstOperator(new BigDecimal(5.0)).secondOperator((null)).operator("+").build();
    }

    public static OperationResultDTO createResultNull() {
        return OperationResultDTO.builder().operationResult(null).build();
    }

    public static OperationDTO createOperationFaultOperator() {
        return OperationDTO.builder().firstOperator(new BigDecimal(5.0)).secondOperator(new BigDecimal(5.0)).operator("6666").build();
    }

    public static MathOperatorService createMathOperatorAdd() {
        MathOperatorService mathOperatorService = new MathOperatorServiceAddImpl();
        return mathOperatorService;
    }

    public static MathOperatorService createMathOperatorSub() {
        MathOperatorService mathOperatorService = new MathOperatorServiceSubImpl();
        return mathOperatorService;
    }
}
