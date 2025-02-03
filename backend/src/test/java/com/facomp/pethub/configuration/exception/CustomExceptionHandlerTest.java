package com.facomp.pethub.configuration.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
class CustomExceptionHandlerTest {

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private ServletWebRequest servletWebRequest ;


    private final String uri = "/test";

    private final CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testHandleRegisterNotFoundException() {

        when(servletWebRequest.getRequest()).thenReturn(httpServletRequest);
        when(httpServletRequest.getRequestURI()).thenReturn(uri);

        ResponseEntity<Object> response = customExceptionHandler.handleRegisterNotFoundException(
                new RegisterNotFoundException(1), servletWebRequest
        );

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testHandleBusinessException() {
        when(servletWebRequest.getRequest()).thenReturn(httpServletRequest);
        when(httpServletRequest.getRequestURI()).thenReturn(uri);

        ResponseEntity<Object> response =  customExceptionHandler.handleBusinessException(
                new BusinessException("Teste", HttpStatus.BAD_REQUEST), servletWebRequest
        );

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testHandleBusinessExceptionWithoutStatus() {
        when(servletWebRequest.getRequest()).thenReturn(httpServletRequest);
        when(httpServletRequest.getRequestURI()).thenReturn(uri);

        ResponseEntity<Object> response = customExceptionHandler.handleBusinessException(
                new BusinessException("Teste"), servletWebRequest
        );

        assertNotNull(response);
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }

    @Test
    void testHandleMethodArgumentNotValidException() {
        MethodArgumentNotValidException exception = mock(MethodArgumentNotValidException.class);
        BindingResult bindingResult = mock(BindingResult.class);
        FieldError fieldError = new FieldError("TEST OBJ", "TEST FIELD", "TEST MSG");
        List<FieldError> fieldErrors = Collections.singletonList(fieldError);

        when(exception.getBindingResult()).thenReturn(bindingResult);
        when(bindingResult.getFieldErrors()).thenReturn(fieldErrors);
        when(servletWebRequest.getRequest()).thenReturn(httpServletRequest);
        when(httpServletRequest.getRequestURI()).thenReturn(uri);

        ResponseEntity<Object> response = customExceptionHandler.handleMethodArgumentNotValid(
                exception,
                HttpHeaders.EMPTY,
                HttpStatusCode.valueOf(400),
                servletWebRequest
        );

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }


}