package christmas.validation;

import christmas.util.ExceptionUtil;
import christmas.util.StringUtil;

public class StringValidator {
    public static void validateRegexPattern(String value, String errorMessage) {
        if (!StringUtil.isValidPattern(value)) {
            ExceptionUtil.throwIllegalArgumentException(errorMessage);
        }
    }
}
