package christmas.validation;

import static christmas.message.ErrorMessage.INVALID_DATE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerValidatorTest {
    @DisplayName("숫자가 아닌 값이 입력될 때 예외가 발생한다.")
    @Test
    void InvalidNumberInteger() {
        assertThatThrownBy(() -> IntegerValidator.validateInteger("55j", INVALID_DATE_MESSAGE.getMessage()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
