package christmas.util;

import static christmas.configuration.StringConstant.DELIMITER_COMMA;
import static christmas.configuration.StringConstant.DELIMITER_DASH;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilTest {

    @DisplayName("컴마에 의해 정상적으로 나누어지는지 테스트")
    @Test
    void SplitByCommaTest () {
        assertEquals(StringUtil.splitBy("아이스크림-3,티본스테이크-2", DELIMITER_COMMA.getValue())
                , List.of("아이스크림-3", "티본스테이크-2"));
    }

    @DisplayName("대시에 의해 정상적으로 나누어지는지 테스트")
    @Test
    void SplitByDashTest () {
        assertEquals(StringUtil.splitBy("아이스크림-3", DELIMITER_DASH.getValue())
                , List.of("아이스크림","3"));
    }
}
