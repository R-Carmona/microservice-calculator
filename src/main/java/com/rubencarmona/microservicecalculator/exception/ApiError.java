package com.rubencarmona.microservicecalculator.exception;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;
/**
 * Clase para retornar un mensaje personalizado en las excepciones.
 */
@Setter
@Getter
@Builder
public class ApiError {
    HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    LocalDateTime date;
    String message;
}
