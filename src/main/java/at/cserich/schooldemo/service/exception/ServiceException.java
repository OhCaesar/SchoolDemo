package at.cserich.schooldemo.service.exception;

import jakarta.persistence.PersistenceException;

public class ServiceException extends RuntimeException{

    // Util
    private static final String PASSED_FUNCTION_NULL = "Passed function on secureExecute method is null!";

    private static final String SECURE_FIND_FAILED_BECAUSE_OF_DATABASE_PROBLEM = "Cannot execute transaction due to database problem! Identifier [%s]";
    private static final String SECURE_FIND_FAILED_BECAUSE_OF_DATABASE_PROBLEM_NULL_IDENTIFIER = "Cannot execute transaction due to database problem! Identifier was null!";
    private static final String SECURE_FIND_FAILED_DUE_TO_UNDETERMINED_REASONS = "Cannot execute transaction due to undetermined Reasons! Identifier [%s]";
    private static final String SECURE_FIND_FAILED_DUE_TO_UNDETERMINED_REASONS_NULL_IDENTIFIER = "Cannot execute transaction due to undetermined Reasons! Identifier was null!";

    protected ServiceException(String message, Throwable rootCause) { super(message, rootCause);}
    protected ServiceException(String message) { super(message);}

    public static ServiceException passedNullFunction() {
        return new ServiceException(PASSED_FUNCTION_NULL, null);
    }

    public static <T> ServiceException secureFindFailed(T identifier, PersistenceException pEx) {
        String msg = (identifier == null)
                ? SECURE_FIND_FAILED_BECAUSE_OF_DATABASE_PROBLEM_NULL_IDENTIFIER
                : SECURE_FIND_FAILED_BECAUSE_OF_DATABASE_PROBLEM.formatted(identifier);
        return new ServiceException(msg, pEx);
    }

    public static<T> ServiceException secureFindFailedForUndeterminedReason(T identifier, Throwable t){
        String msg = (identifier == null)
                ? SECURE_FIND_FAILED_DUE_TO_UNDETERMINED_REASONS_NULL_IDENTIFIER
                : SECURE_FIND_FAILED_DUE_TO_UNDETERMINED_REASONS.formatted(identifier);
        return new ServiceException(msg, t);
    }
}
