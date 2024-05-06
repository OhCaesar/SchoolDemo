package at.cserich.schooldemo.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadArgumentException extends RuntimeException {

    public BadArgumentException(String message, Exception e) {
        super(message, e);
    }

}