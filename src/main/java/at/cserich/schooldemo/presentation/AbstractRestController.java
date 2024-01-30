package at.cserich.schooldemo.presentation;

import at.cserich.schooldemo.presentation.exception.BadArgumentException;
import at.cserich.schooldemo.presentation.exception.ForbiddenException;
import at.cserich.schooldemo.presentation.exception.InternalServerException;
import at.cserich.schooldemo.service.exception.AccessDeniedException;
import at.cserich.schooldemo.service.exception.ServiceException;
import at.cserich.schooldemo.service.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@CrossOrigin
public abstract class AbstractRestController {
    public <T> T wrappedServiceExecution(Supplier<T> supplier) {
        if(supplier == null) {
            log.warn("Null Supplier passed in wrappedServiceExecution");
            throw new InternalServerException("Passed Null SupplierFunction in wrappedServiceExecution", null);
        }
        try {
            return supplier.get();
        } catch (NullPointerException | IllegalArgumentException | ValidationException e) {
            log.warn("Encountered exception while updating entity: Type: {} - Msg: {}", e.getClass().getSimpleName(), e.getMessage());
            throw new BadArgumentException(e.getMessage(), e);
        } catch (AccessDeniedException e) {
            log.warn("Encountered exception while updating entity: Type: {} - Msg: {}", e.getClass().getSimpleName(), e.getMessage());
            throw new ForbiddenException(e.getMessage(), e);
        }
        catch (ServiceException e) {
            log.warn("Encountered exception while updating entity: Type: {} - Msg: {}", e.getClass().getSimpleName(), e.getMessage());
            throw new InternalServerException(e.getMessage(), e);
        }
    }

    public <T, G> T wrappedServiceExecution(G command, Function<G, T> func) {
        if(func == null){
            log.warn("Passed Null Function in wrappedServiceExecution");
            throw new InternalServerException("Passed Null Function in wrappedServiceExecution", null);
        }
        try {
            return func.apply(command);
        } catch (NullPointerException | IllegalArgumentException | ValidationException e) {
            log.warn("Encountered exception while updating entity: Type: {} - Msg: {}", e.getClass().getSimpleName(), e.getMessage());
            throw new BadArgumentException(e.getMessage(), e);
        } catch (AccessDeniedException e) {
            log.warn("Encountered exception while updating entity: Type: {} - Msg: {}", e.getClass().getSimpleName(), e.getMessage());
            throw new ForbiddenException(e.getMessage(), e);
        } catch (ServiceException e) {
            log.warn("Encountered exception while updating entity: Type: {} - Msg: {}", e.getClass().getSimpleName(), e.getMessage());
            throw new InternalServerException(e.getMessage(), e);
        }
    }

    public <T, G, X> T wrappedServiceExecution(G identifier, X command, BiFunction<G, X, T> func) {
        if(func == null){
            log.warn("Passed Null Function in wrappedServiceExecution");
            throw new InternalServerException("Passed Null Function in wrappedServiceExecution", null);
        }
        try {
            return func.apply(identifier, command);
        } catch (NullPointerException | IllegalArgumentException | ValidationException e) {
            log.warn("Encountered exception while updating entity: Type: {} - Msg: {}", e.getClass().getSimpleName(), e.getMessage());
            throw new BadArgumentException(e.getMessage(), e);
        } catch (AccessDeniedException e) {
            log.warn("Encountered exception while updating entity: Type: {} - Msg: {}", e.getClass().getSimpleName(), e.getMessage());
            throw new ForbiddenException(e.getMessage(), e);
        } catch (ServiceException e) {
            log.warn("Encountered exception while updating entity: Type: {} - Msg: {}", e.getClass().getSimpleName(), e.getMessage());
            throw new InternalServerException(e.getMessage(), e);
        }
    }

    public void wrappedServiceExecution(Runnable func) {
        if(func == null){
            log.warn("Passed Null Function in wrappedServiceExecution");
            throw new InternalServerException("Passed Null Function in wrappedServiceExecution", null);
        }
        try {
            func.run();
        } catch (NullPointerException | IllegalArgumentException | ValidationException e) {
            log.warn("Encountered exception while updating entity: Type: {} - Msg: {}", e.getClass().getSimpleName(), e.getMessage());
            throw new BadArgumentException(e.getMessage(), e);
        } catch (AccessDeniedException e) {
            log.warn("Encountered exception while updating entity: Type: {} - Msg: {}", e.getClass().getSimpleName(), e.getMessage());
            throw new ForbiddenException(e.getMessage(), e);
        } catch (ServiceException e) {
            log.warn("Encountered exception while updating entity: Type: {} - Msg: {}", e.getClass().getSimpleName(), e.getMessage());
            throw new InternalServerException(e.getMessage(), e);
        }
    }

    public<T> void wrappedServiceExecution(T identifier, Consumer<T> func) {
        if(func == null){
            log.warn("Passed Null Function in wrappedServiceExecution");
            throw new InternalServerException("Passed Null Function in wrappedServiceExecution", null);
        }
        try {
            func.accept(identifier);
        } catch (NullPointerException | IllegalArgumentException | ValidationException e) {
            log.warn("Encountered exception while updating entity: Type: {} - Msg: {}", e.getClass().getSimpleName(), e.getMessage());
            throw new BadArgumentException(e.getMessage(), e);
        } catch (AccessDeniedException e) {
            log.warn("Encountered exception while updating entity: Type: {} - Msg: {}", e.getClass().getSimpleName(), e.getMessage());
            throw new ForbiddenException(e.getMessage(), e);
        } catch (ServiceException e) {
            log.warn("Encountered exception while updating entity: Type: {} - Msg: {}", e.getClass().getSimpleName(), e.getMessage());
            throw new InternalServerException(e.getMessage(), e);
        }
    }
}
