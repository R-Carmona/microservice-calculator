package com.rubencarmona.microservicecalculator.util;
import com.google.gson.Gson;
import com.rubencarmona.microservicecalculator.domain.dto.OperationDTO;
import com.rubencarmona.microservicecalculator.domain.dto.OperationResultDTO;
import java.math.BigDecimal;
import java.util.logging.Logger;

/**
 * Clase de utilidad para pasar objetos a formato json, necesarios para las llamadas con postman y similares.
 */
public class CreateJSON {

    public static void main(String[] args) {
        final Logger LOGGER = Logger.getLogger(CreateJSON.class.getName());

        LOGGER.info(new Gson().toJson(OperationDTO.builder().firstOperator(new BigDecimal(5)).secondOperator(new BigDecimal(5)).operator("+").build()));
        LOGGER.info(new Gson().toJson(OperationResultDTO.builder().operationResult(new BigDecimal(5))));
    }

}