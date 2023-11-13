package christmas.util.validate;

public interface ExceptionType<T> {
    static final String MESSAGE_FORMAT = "[ERROR] %s";

    String getMessage();

    T getException();
}
