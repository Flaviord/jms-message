package com.jms.example.demo.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

@Service
@Slf4j
public class JmsErrorHandler implements ErrorHandler {

    @Override
    public void handleError(Throwable t) {
        log.warn("ERROR HAPPENED");
        log.error("ERROR MESSAGE: {}", t.getMessage());
    }
}
