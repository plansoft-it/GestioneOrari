package errors;

import java.io.IOException;

public class WrongFormatException extends IOException{
	    public WrongFormatException(String errorMessage) {
	        super(errorMessage);
	    }
	    
	    public WrongFormatException(String errorMessage, Throwable errorCause) {
	        super(errorMessage, errorCause);
	    }
}
