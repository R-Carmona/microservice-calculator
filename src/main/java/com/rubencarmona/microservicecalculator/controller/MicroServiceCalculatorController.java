package com.rubencarmona.microservicecalculator.controller;

import com.rubencarmona.microservicecalculator.domain.dto.OperationDTO;
import com.rubencarmona.microservicecalculator.domain.dto.OperationResultDTO;
import com.rubencarmona.microservicecalculator.exception.ApiError;
import com.rubencarmona.microservicecalculator.exception.OperationBadRequest;
import com.rubencarmona.microservicecalculator.service.MicroServiceCalculatorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.logging.Logger;

/**
 * Controlador principal.
 */
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MicroServiceCalculatorController {

    private final Logger LOGGER = Logger.getLogger(MicroServiceCalculatorController.class.getName());
    private MicroServiceCalculatorService microServiceCalculatorService;

    /**
     * Método para la obtención del resultado de las operaciones.
     * @param operationDTO Request con dos valores y un operador.
     * @return BigDecimal con el resultado de la operación.
     */
    @PostMapping("/operation")
    public ResponseEntity<OperationResultDTO> add(@RequestBody OperationDTO operationDTO) {
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
    public void validator(OperationDTO operationDTO) {
        LOGGER.info("Walking through the ValidatorServiceImpl: " + LOGGER.getName());

        /**
         * Comprobamos que el operador no venga vacío.
         * Nunca puede venir nulo pues el JSON debe de contener el valor cómo String,
         * si no hay cadena vacía el controlador dará BAD_REQUIEST.
         */
        if(operationDTO.getOperator().isEmpty() || operationDTO.getOperator().isBlank()){
            LOGGER.warning("Operador con cadena vacía: " + LOGGER.getName());
            throw  new OperationBadRequest("Operador con cadena vacía");
        }else if(!operationDTO.getOperator().equals("+") && !operationDTO.getOperator().equals("-")){
            LOGGER.warning("Operador no permitido: " + LOGGER.getName());
            throw new OperationBadRequest("Operador no permitido");
        }

    }

    /**
     * Método anotado con ExceptionHandler para manejar la excepción cuando se produzca.
     * @param ex Excepción personalizada.
     * @return clase personalizada con información del error.
     */
    @ExceptionHandler(OperationBadRequest.class)
    public ResponseEntity<ApiError> operationResponseBadRequest(OperationBadRequest ex) {
        LOGGER.warning("Walking through the operationResponseBadRequest: " + LOGGER.getName());
        ApiError apiError = ApiError.builder().status(HttpStatus.BAD_REQUEST).date(LocalDateTime.now()).message(ex.getMessage()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
}
