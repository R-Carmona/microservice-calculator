package com.rubencarmona.microservicecalculator.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * Clase para la transferencia del resultado de la operación.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationResultDTO implements Serializable {
    BigDecimal operationResult;
}
