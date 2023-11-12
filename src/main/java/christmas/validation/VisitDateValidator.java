package christmas.validation;

import static christmas.configuration.IntegerConstant.MAX_DAY;
import static christmas.configuration.IntegerConstant.MIN_DAY;
import static christmas.message.ErrorMessage.INVALID_DATE_MESSAGE;

import christmas.util.ExceptionUtil;

public class VisitDateValidator {
    protected void validateDate(int date) {
        if(!(date >= MIN_DAY.getValue() && date <= MAX_DAY.getValue())) {
            ExceptionUtil.throwIllegalArgumentException(INVALID_DATE_MESSAGE.getMessage());
        }
    }
}
