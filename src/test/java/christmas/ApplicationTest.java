package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @DisplayName("전체 타이틀 출력 테스트")
    @Test
    void 모든_타이틀_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
            );
        });
    }

    @DisplayName("이벤트 대상이 아닐때 테스트")
    @Test
    void 혜택_내역_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
        });
    }

    @DisplayName("날짜 예외 테스트 1")
    @Test
    void 날짜_예외_테스트_1() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("날짜 예외 테스트 2")
    @Test
    void 날짜_예외_테스트_2() {
        assertSimpleTest(() -> {
            runException("32");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("주문 예외 테스트")
    @Test
    void 주문_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("음료만 주문시 테스트")
    @Test
    void 음료_주문_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-3");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("메뉴에 없는 주문 테스트")
    @Test
    void 메뉴_없는_주문_테스트() {
        assertSimpleTest(() -> {
            runException("3", "오징어-3");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("평일 할인 테스트")
    @Test
    void 평일_할인_테스트() {
        assertSimpleTest(() -> {
            run("5", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                    "평일 할인:"
            );
        });
    }

    @DisplayName("크리스마스 디데이 종료 테스트")
    @Test
    void 크리스마스_디데이_종료() {
        assertSimpleTest(() -> {
            run("26", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).doesNotContain(
                    "크리스마스 디데이 할인:"
            );
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
