package christmas.util.constatnt;

public enum ExceptionMessage {

    INVALID_DATE_INPUT("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_MENU_INPUT("유효하지 않은 주문입니다. 다시 입력해 주세요.");


    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}