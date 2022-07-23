package com.rubencarmona.microservicecalculator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
public class OperationResult {
    BigDecimal operationResult;
}