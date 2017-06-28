package be.doji.playground.micro.MicroServiceTest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Doji on 28/06/2017.
 */
@ResponseStatus(HttpStatus.NOT_FOUND) public class DataNotFoundException extends Exception {

    public DataNotFoundException(String reason) {
        super(reason);
    }

    public DataNotFoundException(String reason, Throwable cause) {
        super(reason, cause);
    }
}
