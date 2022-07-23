package com.rubencarmona.microservicecalculator.controller;

import com.rubencarmona.microservicecalculator.domain.dto.OperationDTO;
import com.rubencarmona.microservicecalculator.domain.dto.OperationResultDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class MicroServiceCalculatorController {

    private final Logger LOGGER = Logger.getLogger(MicroServiceCalculatorController.class.getName());

    @PostMapping("/operation")
    public ResponseEntity<OperationResultDTO> add(@RequestBody OperationDTO operationDTO) {
        return null;
    }
}
