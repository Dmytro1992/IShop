package httpserver.io.exception;

public class HttpVersionNotSupportedException extends AbstractRequestParseFailedException {
	private static final long serialVersionUID = 582489146028283839L;

	public HttpVersionNotSupportedException(String message, String startingLine) {
		super(message, startingLine);
		setStatusCode(505);
	}
}
