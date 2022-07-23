package com.rubencarmona.microservicecalculator.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationDTO implements Serializable {
    BigDecimal firstOperator;
    BigDecimal secondOperator;
    String operator;
}
