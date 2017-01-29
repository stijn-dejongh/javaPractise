package be.doji.practise.filefixit.exception;

/**
 * 
 * @author doji
 *
 */
public class FileProcessingException extends Exception {

	private static final long serialVersionUID = 5928825106712109525L;

	public FileProcessingException() {
		this("Something went wrong while processing a file");
	}

	public FileProcessingException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileProcessingException(String message) {
		super(message);
	}

	
}
