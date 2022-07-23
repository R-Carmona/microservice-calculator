package com.rubencarmona.microservicecalculator.service;

import com.rubencarmona.microservicecalculator.domain.dto.OperationDTO;
import com.rubencarmona.microservicecalculator.domain.dto.OperationResultDTO;

public interface MicroServiceCalculatorService {

    OperationResultDTO getOperation(OperationDTO operationDT);
    void saveTracerResult(OperationResultDTO operationResultDTO);
}
