package christmas.domain;

import static christmas.configuration.DateConstant.TUESDAY;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.entity.VisitDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VisitDateTest {
    @DisplayName("정상 날짜 입력 테스트")
    @Test
    void goodAddOrderTest() {
        assertThatCode(() -> VisitDate.create(12))
                .doesNotThrowAnyException();
    }

    @DisplayName("비정상 날짜 입력 예외 테스트")
    @Test
    void badAddOrderTest_1() {
        assertThatThrownBy(() -> VisitDate.create(50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("요일 테스트")
    @Test
    void weekTest() {
        VisitDate visitDate = VisitDate.create(12);
        assertEquals(visitDate.getWeek(), TUESDAY.getValue());
    }
}
