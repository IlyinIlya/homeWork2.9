package Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongNamesException extends RuntimeException{

        public WrongNamesException() {
        }

        public WrongNamesException(String message) {
            super(message);
        }

        public WrongNamesException(String message, Throwable cause) {
            super(message, cause);
        }

        public WrongNamesException(Throwable cause) {
            super(cause);
        }

        public WrongNamesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
}
