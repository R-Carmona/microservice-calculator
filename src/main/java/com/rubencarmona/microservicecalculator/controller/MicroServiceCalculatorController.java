package com.rubencarmona.microservicecalculator.controller;

import com.rubencarmona.microservicecalculator.domain.dto.OperationDTO;
import com.rubencarmona.microservicecalculator.domain.dto.OperationResultDTO;
import com.rubencarmona.microservicecalculator.exception.ApiError;
import com.rubencarmona.microservicecalculator.exception.OperationBadRequest;
import com.rubencarmona.microservicecalculator.service.MathOperatorService;
import com.rubencarmona.microservicecalculator.service.MicroServiceCalculatorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;
/**
 * Controlador principal.
 */
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MicroServiceCalculatorController {

    private static final Logger LOGGER = Logger.getLogger(MicroServiceCalculatorController.class.getName());
    private MicroServiceCalculatorService microServiceCalculatorService;

    private ApplicationContext context;
    /**
     * Método para la obtención del resultado de las operaciones.
     * @param operationDTO Request con dos valores y un operador.
     * @return BigDecimal con el resultado de la operación.
     */
    @ApiOperation(
            value = "Devuelve el resultado de dos operaciones aritméticas.",
            nickname = "Devuelve el resultado de dos operaciones aritméticas.",
            response = OperationResultDTO.class)
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success", response = OperationResultDTO.class),
                    @ApiResponse(code = 400, message = "Bad Request", response = ApiError.class),
                    @ApiResponse(code = 500, message = "Internal Server Error")
            })
    @PostMapping("/operation")
    private ResponseEntity<OperationResultDTO> operation(@ApiParam(value = "Datos para la operación, TODOS los campos son REQUERIDOS. Operator solo admite, suma o resta: + , -",required = true,type = "OperationDTO") @RequestBody OperationDTO operationDTO) {
        LOGGER.info("Walking through the controller: " + LOGGER.getName());
        validator(operationDTO);
        OperationResultDTO operationResultDTO = microServiceCalculatorService.getOperation(operationDTO);
        return ResponseEntity.ok().body(operationResultDTO);
    }

    /**
     * Método para la validación de los datos, solamente validamos el operador de la operación, pues
     * el resto de los datos son validados al recibir el JSON, si no son correctos se responderá
     * BAD_REQUEST.
     * @param operationDTO
     */
    private void validator(OperationDTO operationDTO) {
        LOGGER.info("Walking through the ValidatorServiceImpl: " + LOGGER.getName());

        /**
         * Validamos si nos viene algún dato a null.
         */
        if(operationDTO.getFirstOperator() == null){
            throw  new OperationBadRequest("Primer operador es nulo.");
        }  else if (operationDTO.getSecondOperator() == null) {
            throw  new OperationBadRequest("Segundo operador es nulo.");
        } else if (operationDTO.getOperator() == null) {
            throw  new OperationBadRequest("El operador es nulo.");
        }

        /**
         * Comprobamos que el operador no venga vacío.
         */
        if(operationDTO.getOperator().isEmpty() || operationDTO.getOperator().isBlank()){
            LOGGER.warning("Operador con cadena vacía: " + LOGGER.getName());
            throw  new OperationBadRequest("Operador con cadena vacía");
        }
        /**
         * Capturamos la excepción si no existe el bean, querrá decir que no tenemos implementada
         * la operación.
         */
        try {
            this.context.getBean(operationDTO.getOperator(), MathOperatorService.class);
        } catch (NoSuchBeanDefinitionException e){
            LOGGER.warning("Operador no permitido: " + LOGGER.getName());
            throw new OperationBadRequest("Operador no permitido");
        }

    }
}
