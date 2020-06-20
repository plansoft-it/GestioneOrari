package errors;

import java.io.IOException;

public class WrongFormatException extends IOException{
	    /** serial version UID */
	private static final long serialVersionUID = 1L;

		public WrongFormatException(String errorMessage) {
	        super(errorMessage);
	    }
	    
	    public WrongFormatException(String errorMessage, Throwable errorCause) {
	        super(errorMessage, errorCause);
	    }
}
