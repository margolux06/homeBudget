package com.urban.gosia.exceptions;

import com.urban.gosia.bankAccount.BankAccountNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseBody
    public ExceptionJSONInfo handleEmptyResultDataAccessException(EmptyResultDataAccessException e) {
        return new ExceptionJSONInfo(e.getMessage());
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(BankAccountNotFoundException.class)
    @ResponseBody
    public ExceptionJSONInfo handleBankAccountNotFoundException(BankAccountNotFoundException e) {
        return new ExceptionJSONInfo(String.format("Account %d not found!", e.getBankAccountId()));
    }
}
