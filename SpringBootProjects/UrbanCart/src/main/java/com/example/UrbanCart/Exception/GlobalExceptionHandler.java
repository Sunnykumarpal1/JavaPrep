package com.example.UrbanCart.Exception;

import com.example.UrbanCart.dto.ErrorResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InsufficientItemException.class)
    ResponseEntity<ErrorResponseMessage>handleInsufficientItem(InsufficientItemException exp){
        ErrorResponseMessage errorResponseMessage=new ErrorResponseMessage(exp.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponseMessage,HttpStatus.BAD_REQUEST );
    }


    @ExceptionHandler(UserNotFoundException.class)
    ResponseEntity<ErrorResponseMessage>userNotExist(UserNotFoundException exp){
        ErrorResponseMessage error=new ErrorResponseMessage(exp.getMessage(),HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    ResponseEntity<ErrorResponseMessage>peroductNotExist(ProductNotFoundException  exp){
        ErrorResponseMessage error=new ErrorResponseMessage(exp.getMessage(),HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorResponseMessage>handleGlobalException(Exception exp){
        ErrorResponseMessage error=new ErrorResponseMessage("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
