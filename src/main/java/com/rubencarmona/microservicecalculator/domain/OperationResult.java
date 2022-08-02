package com.rubencarmona.microservicecalculator.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
/**
 * Clase con los datos del resultado de la operación.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationResult {
    private BigDecimal operationResult;
}
