package com.solution.test.controller.apiadvice;

import com.solution.test.dto.Response;
import com.solution.test.exception.BadRequestException;
import com.solution.test.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(ApiAdvice.class);

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public Response exceptionHandler(BadRequestException e) {
        return new Response(String.valueOf(HttpStatus.BAD_REQUEST.value()), e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public Response exceptionHandler(NotFoundException e) {
        return new Response(String.valueOf(HttpStatus.NOT_FOUND.value()), e.getMessage());
    }
	
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ResponseBody
    public Response handleAccessDeniedException(AccessDeniedException e) {
        Response response = new Response();
        response.setCode("10013");
        response.setDescription(e.getMessage());
        return response;
    }
}
