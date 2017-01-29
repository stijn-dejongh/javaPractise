package be.doji.practise.filefixit.exception;

/**
 * Created by Doji on 29/01/2017.
 */
public class NoParentFoundException extends Exception {

    public NoParentFoundException(String errorMessage) {
        super(errorMessage);
    }

    public NoParentFoundException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
