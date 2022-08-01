package com.rubencarmona.microservicecalculator.service;

import java.math.BigDecimal;

public interface MathOperatorService {

    BigDecimal operator(BigDecimal firstOperator, BigDecimal secondOperator);
}
