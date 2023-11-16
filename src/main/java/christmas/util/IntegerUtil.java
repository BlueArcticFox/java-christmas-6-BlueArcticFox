package christmas.util;

import christmas.validation.IntegerValidator;

public class IntegerUtil {
    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static int convertInt(String value, String errorMessage) {
        value = value.trim();
        IntegerValidator.validateInteger(value, errorMessage);

        return Integer.parseInt(value);
    }
}
