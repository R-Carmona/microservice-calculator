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

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MicroServiceCalculatorController {

    private final Logger LOGGER = Logger.getLogger(MicroServiceCalculatorController.class.getName());
    private MicroServiceCalculatorService microServiceCalculatorService;

    @PostMapping("/operation")
    public ResponseEntity<OperationResultDTO> add(@RequestBody OperationDTO operationDTO) {
        LOGGER.info("Walking through the controller: " + LOGGER.getName());
        validator(operationDTO);
        OperationResultDTO operationResultDTO = microServiceCalculatorService.getOperation(operationDTO);
        return ResponseEntity.ok().body(operationResultDTO);
    }

    public void validator(OperationDTO operationDTO) {
        LOGGER.info("Walking through the ValidatorServiceImpl: " + LOGGER.getName());

        if(operationDTO.getOperator().isEmpty() || operationDTO.getOperator().isBlank()){
            LOGGER.warning("Operador nulo o cadena vacía: " + LOGGER.getName());
            throw  new OperationBadRequest("Operador nulo o cadena vacía");
        }else if(!operationDTO.getOperator().equals("+") && !operationDTO.getOperator().equals("-")){
            LOGGER.warning("Operador no permitido: " + LOGGER.getName());
            throw new OperationBadRequest("Operador no permitido");
        }

    }

    @ExceptionHandler(OperationBadRequest.class)
    public ResponseEntity<ApiError> operationResponseBadRequest(OperationBadRequest ex) {
        LOGGER.warning("Walking through the operationResponseBadRequest: " + LOGGER.getName());
        ApiError apiError = ApiError.builder().status(HttpStatus.BAD_REQUEST).date(LocalDateTime.now()).message(ex.getMessage()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
}
