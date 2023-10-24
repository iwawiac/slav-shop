package pl.hireme.slavshop.common.web.exceptionhandler;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.hireme.slavshop.products.ProductNotFoundException;

import java.util.Locale;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionTransferObject> onException(Exception ex, Locale locale) {
        ex.printStackTrace();
        return createResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, locale);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionTransferObject> onProductNotFoundException(ProductNotFoundException ex, Locale locale) {
        return createResponse(ex, HttpStatus.NOT_FOUND, locale);
    }

    private ResponseEntity<ExceptionTransferObject> createResponse(Exception ex, HttpStatus status, Locale locale) {

        String exceptionName = ex.getClass().getSimpleName();
        String description;

        try{
            description = messageSource.getMessage(ex.getClass().getSimpleName(), null, locale);
        } catch (NoSuchMessageException exception) {
            description = exceptionName;
        }
        ex.printStackTrace();
        return ResponseEntity.status(status).body((new ExceptionTransferObject(description)));
    }

}
