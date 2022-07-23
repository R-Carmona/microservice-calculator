package com.rubencarmona.microservicecalculator.helpers;

import com.rubencarmona.microservicecalculator.domain.dto.OperationDTO;
import com.rubencarmona.microservicecalculator.domain.dto.OperationResultDTO;

import java.math.BigDecimal;

public class DatosHelper {

    public static OperationDTO createOperation() {
       return OperationDTO.builder().firstOperator(new BigDecimal(5.0)).secondOperator(new BigDecimal(5.0)).operator("+").build();
    }

    public static OperationResultDTO createResult() {
        return OperationResultDTO.builder().operationResult(new BigDecimal(10.0)).build();
    }
}
