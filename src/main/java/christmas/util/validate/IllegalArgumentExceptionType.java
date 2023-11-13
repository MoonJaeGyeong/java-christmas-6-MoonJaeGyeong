package christmas.util.validate;

public enum IllegalArgumentExceptionType implements ExceptionType<IllegalArgumentException> {
    DAY_INPUT_ERROR("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    MENU_INPUT_ERROR("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    IllegalArgumentExceptionType(String message) {
        this.message = String.format(MESSAGE_FORMAT, message);
    }

    public String getMessage() {
        return message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(getMessage());
    }
}
