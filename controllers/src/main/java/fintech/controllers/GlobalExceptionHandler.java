package fintech.controllers;

import fintech.data.impl.exceptions.GetRepositoryException;
import fintech.data.impl.exceptions.SaveRepositoryException;
import fintech.services.impl.exceptions.InvalidLanguageException;
import fintech.services.impl.exceptions.NotFoundException;
import fintech.services.impl.exceptions.TranslateException;
import fintech.services.impl.exceptions.TranslateRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>("Resource not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidLanguageException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleInvalidLanguageException(InvalidLanguageException ex) {
        return new ResponseEntity<>("Invalid language in request", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GetRepositoryException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleGetRepositoryException(GetRepositoryException ex) {
        return new ResponseEntity<>("Error retrieving data", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SaveRepositoryException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleSaveRepositoryException(SaveRepositoryException ex) {
        return new ResponseEntity<>("Error saving data", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TranslateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleTranslateException(TranslateException ex) {
        return new ResponseEntity<>("Error during translation", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TranslateRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleTranslateRequestException(TranslateRequestException ex) {
        return new ResponseEntity<>("Error during translation request", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
