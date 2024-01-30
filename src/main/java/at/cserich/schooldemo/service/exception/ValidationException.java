package at.cserich.schooldemo.service.exception;

import jakarta.validation.ConstraintViolationException;

public class ValidationException extends RuntimeException{
    private static final String VALLIDATION_FAILED = "Cannot save entity [%s] because invalid arguments have been passed in! Violations: ";
    private static final String VALLIDATION_FAILED_WITH_NULL_ENTITY = "Cannot save entity because invalid arguments have been passed in! Violations: ";

    protected ValidationException(String message, Exception exception) {
        super(message, exception);
    }

    protected ValidationException(String message) {
        super(message);
    }

    public static<T> ValidationException invalidEntity(T entity, ConstraintViolationException e){
        String msg = (entity == null)
                ? VALLIDATION_FAILED_WITH_NULL_ENTITY.concat(String.join(" ", e.getConstraintViolations().stream().map(Object::toString).toList()))
                : VALLIDATION_FAILED.formatted(entity.toString()).concat(String.join(" ", e.getConstraintViolations().stream().map(Object::toString).toList()));
        return new ValidationException(msg, e);
    }
}