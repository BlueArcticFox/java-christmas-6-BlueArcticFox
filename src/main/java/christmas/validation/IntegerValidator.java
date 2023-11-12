package christmas.validation;

import christmas.util.ExceptionUtil;
import christmas.util.IntegerUtil;

public class IntegerValidator {
    public static void validateInteger(String value, String errorMessage) {
        if (!IntegerUtil.isInteger(value)) {
            ExceptionUtil.throwIllegalArgumentException(errorMessage);
        }
    }
}
