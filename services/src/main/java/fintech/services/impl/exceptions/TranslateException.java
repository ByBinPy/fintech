package fintech.services.impl.exceptions;

import fintech.services.impl.TranslateService;

public class TranslateException extends Exception{
    public TranslateException(String message) {
        super(message);
    }
}
