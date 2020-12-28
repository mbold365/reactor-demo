package ru.tsc.reactordemo.handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.netty.http.server.HttpServerResponse;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public void noSuchElementException(HttpServerResponse response) {
        log.debug("Handled NoSuchElementException, sent NOT_FOUND as response");
        response.status(NOT_FOUND.value());
    }
}
