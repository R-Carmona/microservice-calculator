package com.rubencarmona.microservicecalculator.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.math.BigDecimal;
/**
 * Clase para la transferencia de los datos de la operación.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationDTO implements Serializable {


    @ApiModelProperty(value = "Primer operador", dataType = "BigDecimal", example = "1.5", position = 1, required = true)
    private BigDecimal firstOperator;
    @ApiModelProperty(value = "Segundo operador", dataType = "BigDecimal", example = "2.5", position = 2, required = true)
    private BigDecimal secondOperator;
    @ApiModelProperty(value = "Operador, suma=+ / resta=-", dataType = "String", example = "+", position = 3, required = true)
    private String operator;
}
