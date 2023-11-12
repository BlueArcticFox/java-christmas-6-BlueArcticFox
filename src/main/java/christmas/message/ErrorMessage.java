package christmas.message;

public enum ErrorMessage {
    INVALID_DATE_MESSAGE("유효하지 않은 날짜입니다."),
    INVALID_MENU_MESSAGE("유효하지 않은 주문입니다."),
    LIMIT_MENU_SELECTION_MESSAGE("한 번에 최대 20개까지만 주문할 수 있습니다.");
    private final String message;
    private static final String errorPrefix = "[ERROR] ";
    private static final String errorSuffix = " 다시 입력해 주세요.";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return errorPrefix + message + errorSuffix;
    }
}
