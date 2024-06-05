package it.pi.registro.registro.exception;

public class ApiValidationException extends RuntimeException {

    private final int code;

    public ApiValidationException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }
}
