package miraj.basicmicroservice2024.controller;

import lombok.extern.slf4j.Slf4j;
import miraj.basicmicroservice2024.exception.UserException;
import miraj.basicmicroservice2024.response.GeneralResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
@Slf4j
public class GlobalErrorAdvice {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<GeneralResponse> handleRunTimeException(RuntimeException e) {
        log.error("runtime exception occred.", e);
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setStatusCode(111);
        generalResponse.setStatusDesc("This is runtime");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(generalResponse);
    }

    @ExceptionHandler({UserException.class})
    public ResponseEntity<GeneralResponse> handleRunTimeException(UserException e) {
        log.error("internal exception occred error-code={}", e.getErrorCode());
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setStatusCode(e.getErrorCode());
        generalResponse.setMessage(e.getErrorMessage());
        generalResponse.setStatusDesc("internal error");
        generalResponse.setMessageId(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(generalResponse);
    }
}
