package it.pi.registro.registro.configuration;

import it.pi.registro.registro.exception.ApiValidationException;
import it.pi.registro.registro.exception.BadRequestException;
import it.pi.registro.registro.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Map<String, String> handleResourceNotFoundException ( ResourceNotFoundException resourceNotFoundException){

        return new HashMap<String, String>(){
            {
                put("ERROR", resourceNotFoundException.getMessage());
            }
        };
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ma){
        Map<String, String> errors = new HashMap<>();
        ma.getBindingResult().getAllErrors().forEach(objectError -> {
            String fieldName = ((FieldError) objectError).getField();
            String errorMessage = objectError.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleBadRequestException(BadRequestException be){
        return be.getMessage();
    }

    @ExceptionHandler(ApiValidationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public HashMap<String,String> ApiError(ApiValidationException be){
        return new HashMap<String, String>()
        {
            {
                put("ERROR_MESSAGE", be.getMessage());
                put("ERROR_CODE ", String.valueOf(be.getCode()));
            }
        };
    }

}
