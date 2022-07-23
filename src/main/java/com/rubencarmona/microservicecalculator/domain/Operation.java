package com.rubencarmona.microservicecalculator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
/**
 * Clase con los datos de la operación.
 * Primer número a operar.
 * Segundo número a operar y el signo de la operación.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Operation {
    BigDecimal firstOperator;
    BigDecimal secondOperator;
    String operator;
}
