package christmas.validation;

import static christmas.message.ErrorMessage.INVALID_DATE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringValidatorTest {
    @DisplayName("정상 입력에 대한 정규식 테스트")
    @Test
    void goodInputTest_1() {
        assertThatCode(() -> StringValidator.validateRegexPattern("타파스-3", INVALID_DATE_MESSAGE.getMessage()))
                .doesNotThrowAnyException();
    }

    @DisplayName("연속 입력에 대한 정규식 테스트")
    @Test
    void goodInputTest_2() {
        assertThatCode(() -> StringValidator.validateRegexPattern("타파스-3,아이스크림-3", INVALID_DATE_MESSAGE.getMessage()))
                .doesNotThrowAnyException();
    }

    @DisplayName("뒤에 컴마가 있는 입력에 대한 정규식 테스트 - 예외")
    @Test
    void badInputTest_1() {
        assertThatThrownBy(() -> StringValidator.validateRegexPattern("타파스-3,", INVALID_DATE_MESSAGE.getMessage()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("앞자리에 숫자 입력에 대한 정규식 테스트 - 예외")
    @Test
    void badInputTest_2() {
        assertThatThrownBy(() -> StringValidator.validateRegexPattern("3-3,", INVALID_DATE_MESSAGE.getMessage()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("뒷자리에 문자 입력에 대한 정규식 테스트 - 예외")
    @Test
    void badInputTest_3() {
        assertThatThrownBy(() -> StringValidator.validateRegexPattern("타파스-타타,", INVALID_DATE_MESSAGE.getMessage()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
