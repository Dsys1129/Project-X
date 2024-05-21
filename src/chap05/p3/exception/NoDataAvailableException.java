package chap05.p3.exception;

public class NoDataAvailableException extends RuntimeException {
    public NoDataAvailableException(String message) {
        super(message);
    }
}
