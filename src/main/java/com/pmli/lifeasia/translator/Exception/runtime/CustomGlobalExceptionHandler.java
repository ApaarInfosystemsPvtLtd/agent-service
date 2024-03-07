package com.pmli.lifeasia.translator.Exception.runtime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final static Logger log = LogManager.getLogger();

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomErrorResponse> customHandleNotFound(RuntimeException ex, WebRequest request){
        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setClientnum("");
        customErrorResponse.setAgentNum("");
        customErrorResponse.setState("Failure");
        customErrorResponse.setMessage("Life Asia Error.");
        return new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.traceEntry("handleMissingServletRequestParameter {}",request);
        String error = ex.getParameterName() + " parameter is missing";
        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setClientnum("");
        customErrorResponse.setAgentNum("");
        customErrorResponse.setState("Failure");
        customErrorResponse.setMessage("Please check your json Request "+ error);

        return log.traceExit("handleMissingServletRequestParameter {}", new ResponseEntity<>(customErrorResponse,BAD_REQUEST));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.traceEntry("handleMethodArgumentNotValid {}",request);
        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setClientnum("");
        customErrorResponse.setAgentNum("");
        customErrorResponse.setState("Failure");
        customErrorResponse.setMessage("Validation error");

        return log.traceExit("handleMethodArgumentNotValid {}",new ResponseEntity<>(customErrorResponse, BAD_REQUEST));
    }


    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolation(
            javax.validation.ConstraintViolationException ex) {
        log.traceEntry("handleConstraintViolation {}",ex);
        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setClientnum("");
        customErrorResponse.setAgentNum("");
        customErrorResponse.setState("Failure");
        customErrorResponse.setMessage("Validation error");

        return log.traceExit("handleMethodArgumentNotValid {}",new ResponseEntity<>(customErrorResponse, BAD_REQUEST));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.traceEntry("handleHttpMessageNotReadable {}",ex);
        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setClientnum("");
        customErrorResponse.setAgentNum("");
        customErrorResponse.setState("Failure");
        customErrorResponse.setMessage("Please check your json Request" + ex.getMessage());
        return log.traceExit("handleHttpMessageNotReadable {}",new ResponseEntity<>(customErrorResponse,HttpStatus.BAD_REQUEST));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.traceEntry("handleHttpMessageNotWritable {}",request);
        String error = "Error writing JSON output";
        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setClientnum("");
        customErrorResponse.setAgentNum("");
        customErrorResponse.setState("Failure");
        customErrorResponse.setMessage(error+" due to INTERNAL ERROR.!");
        return log.traceExit("handleHttpMessageNotWritable {}",new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(DetailsNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(DetailsNotFoundException ex) {
        log.traceEntry("handleEntityNotFound {}",ex);

        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setClientnum("");
        customErrorResponse.setAgentNum("");
        customErrorResponse.setState("Failure");
        customErrorResponse.setMessage("Please Check your URL "+ex.getMessage());
        return log.traceExit("handleHttpMessageNotWritable {}",new ResponseEntity<>(NOT_FOUND));
    }

    @ExceptionHandler(QuotationGenerationException.class)
    protected ResponseEntity<Object> quotationGenerationException(QuotationGenerationException ex) {
        log.traceEntry("quotationGenerationException {}",ex);
        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setClientnum("");
        customErrorResponse.setAgentNum("");
        customErrorResponse.setState("Failure");
        customErrorResponse.setMessage(ex.getMessage());
        return log.traceExit("quotationGenerationException {}",new ResponseEntity<>(customErrorResponse, BAD_REQUEST));
    }


}