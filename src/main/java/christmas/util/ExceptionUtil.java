package christmas.util;

public class ExceptionUtil {
    public static void throwIllegalArgumentException(String message) {
        System.out.println(message);
        throw new IllegalArgumentException(message);
    }
}
