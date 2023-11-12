package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import christmas.domain.entity.VisitDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DateTest {
    @DisplayName("정상 날짜 입력 테스트")
    @Test
    void goodAddOrderTest() {
        assertThatCode(() -> new VisitDate(12))
                .doesNotThrowAnyException();
    }

    @DisplayName("비정상 날짜 입력 예외 테스트")
    @Test
    void badAddOrderTest_1() {
        assertThatThrownBy(() -> new VisitDate(50))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
