package com.rubencarmona.microservicecalculator.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.logging.Logger;

/**
 * Clase personalizada para lanzar una excepción determinada.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OperationBadRequest extends RuntimeException {

    final Logger LOGGER = Logger.getLogger(OperationBadRequest.class.getName());
    public OperationBadRequest(String message) {
        super(message);
        LOGGER.info("Walking through the OperationBadRequest: " + LOGGER.getName());
    }
}
