package at.cserich.schooldemo.service.exception;

public class AccessDeniedException extends RuntimeException{
    protected AccessDeniedException(String message, Throwable rootCause){
        super(message, rootCause);
    }
    protected AccessDeniedException(String message){
        super(message);
    }
}
