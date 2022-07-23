package com.rubencarmona.microservicecalculator.mapper;

import com.rubencarmona.microservicecalculator.domain.Operation;
import com.rubencarmona.microservicecalculator.domain.OperationResult;
import com.rubencarmona.microservicecalculator.domain.dto.OperationDTO;
import com.rubencarmona.microservicecalculator.domain.dto.OperationResultDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OperationMapperService {

    OperationMapperService INSTANCE = Mappers.getMapper( OperationMapperService.class );

    OperationDTO operationToOperationDTO(Operation operation);

    Operation operationDTOToOperation(OperationDTO operation);

    OperationResultDTO operationResultToOperationResultDTO (OperationResult operationResult);

    OperationResult operationResultDTOToOperationResult (OperationResultDTO operationResult);
}
