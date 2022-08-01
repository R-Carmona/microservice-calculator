package com.rubencarmona.microservicecalculator.service.impl;

import com.rubencarmona.microservicecalculator.service.MathOperatorService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Clase que implementa la interfaz MathOperator y controla el beans que debe
 * de inyectar, realizando la operación correcta.
 */
@Component("-")
@AllArgsConstructor
@Builder
public class MathOperatorServiceSubImpl implements MathOperatorService {
    @Override
    public BigDecimal operator(BigDecimal firstOperator, BigDecimal secondOperator) {
        return firstOperator.subtract(secondOperator);
    }
}
