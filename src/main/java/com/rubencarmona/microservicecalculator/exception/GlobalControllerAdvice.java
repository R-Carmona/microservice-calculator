package com.rubencarmona.microservicecalculator.exception;

import com.rubencarmona.microservicecalculator.controller.MicroServiceCalculatorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;
import java.util.logging.Logger;
@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    final Logger LOGGER = Logger.getLogger(MicroServiceCalculatorController.class.getName());
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
