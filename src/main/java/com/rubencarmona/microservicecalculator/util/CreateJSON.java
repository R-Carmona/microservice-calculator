package com.rubencarmona.microservicecalculator.util;

import com.google.gson.Gson;
import com.rubencarmona.microservicecalculator.domain.dto.OperationDTO;
import com.rubencarmona.microservicecalculator.domain.dto.OperationResultDTO;

import java.math.BigDecimal;

/**
 * Clase de utilidad para pasar objetos a formato json, necesarios para las llamadas con postman y similares.
 */
public class CreateJSON {
    public static void main(String[] args) {

        System.out.println(new Gson().toJson(OperationDTO.builder().firstOperator(new BigDecimal(5)).secondOperator(new BigDecimal(5)).operator("+").build()));
        System.out.println(new Gson().toJson(OperationResultDTO.builder().operationResult(new BigDecimal(5))));
    }

}