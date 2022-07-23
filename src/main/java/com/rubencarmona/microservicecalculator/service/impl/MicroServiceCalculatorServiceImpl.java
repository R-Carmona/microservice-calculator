package com.rubencarmona.microservicecalculator.service.impl;

import com.rubencarmona.microservicecalculator.domain.dto.OperationDTO;
import com.rubencarmona.microservicecalculator.domain.dto.OperationResultDTO;
import com.rubencarmona.microservicecalculator.service.MicroServiceCalculatorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class MicroServiceCalculatorServiceImpl implements MicroServiceCalculatorService {

    @Override
    public OperationResultDTO getOperation(OperationDTO operationDT) {
        return null;
    }

    @Override
    public void saveTracerResult(OperationResultDTO operationResultDTO) {

    }
}
