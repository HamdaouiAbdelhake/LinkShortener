package org.link.shortener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UrlNotFoundException.class)
    public Object handleUrlNotFoundException(UrlNotFoundException ex, WebRequest request) {
        String acceptHeader = request.getHeader("Content-Type");
        ErrorDetails error = new ErrorDetails("Url not found");

        if (acceptHeader != null && acceptHeader.contains("application/json")) {
            // Return JSON response for REST requests
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error);
        } else {
            // Return a web page for browser requests
            ModelAndView modelAndView = new ModelAndView("base");
            modelAndView.addObject("contentFragment", "fragments/error.ftl");
            modelAndView.addObject("errorMessage", "Sorry Url Not Found !!");
            return modelAndView;
        }
    }
}