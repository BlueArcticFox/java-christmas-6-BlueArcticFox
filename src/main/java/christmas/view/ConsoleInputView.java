package christmas.view;

import static christmas.configuration.StringConstant.DELIMITER_COMMA;
import static christmas.message.ErrorMessage.INVALID_DATE_MESSAGE;
import static christmas.message.ErrorMessage.INVALID_MENU_MESSAGE;
import static christmas.message.InputMessage.EXPECTED_DATE_MESSAGE;
import static christmas.message.InputMessage.ORDER_MESSAGE;

import christmas.util.InputUtil;
import christmas.util.IntegerUtil;
import christmas.util.StringUtil;
import christmas.validation.StringValidator;
import java.util.List;

public class ConsoleInputView implements InputView {
    @Override
    public int inputDate() {
        System.out.println(EXPECTED_DATE_MESSAGE.getMessage());
        String input = InputUtil.inputString();
        System.out.println(input);

        return IntegerUtil.convertInt(input, INVALID_DATE_MESSAGE.getMessage());
    }

    @Override
    public List<String> inputOrders() {
        System.out.println(ORDER_MESSAGE.getMessage());
        String input = InputUtil.inputString();
        System.out.println(input);
        StringValidator.validateRegexPattern(input, INVALID_MENU_MESSAGE.getMessage());

        return StringUtil.splitBy(input, DELIMITER_COMMA.getValue());
    }
}
