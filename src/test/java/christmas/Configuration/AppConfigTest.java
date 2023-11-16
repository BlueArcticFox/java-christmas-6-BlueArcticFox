package christmas.Configuration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.configuration.AppConfig;
import christmas.configuration.Config;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppConfigTest {
    private Config config;

    @BeforeEach
    void setUp() {
        config = AppConfig.getInstance();
    }

    @DisplayName("AppConfig가 싱글톤인지 테스트 ")
    @Test
    public void AppConfigTest_1() {
        testSingleton(config) ;
    }

    @DisplayName("InputView가 싱글톤인지 테스트 ")
    @Test
    public void AppConfigTest_2() {
        testSingleton(config.inputView()) ;
    }

    @DisplayName("OutputView가 싱글톤인지 테스트 ")
    @Test
    public void AppConfigTest_3() {
        testSingleton(config.outputView()) ;
    }

    @DisplayName("OdersService가 싱글톤인지 테스트 ")
    @Test
    public void AppConfigTest_4() {
        testSingleton(config.ordersService()) ;
    }

    @DisplayName("PromotionService가 싱글톤인지 테스트 ")
    @Test
    public void AppConfigTest_5() {
        testSingleton(config.promotionService()) ;
    }

    @DisplayName("EventPlanerController가 싱글톤인지 테스트 ")
    @Test
    public void AppConfigTest_6() {
        testSingleton(config.eventPlanerController()) ;
    }

    @DisplayName("scheduleRepository가 싱글톤인지 테스트 ")
    @Test
    public void AppConfigTest_7() {
        testSingleton(config.scheduleRepository()) ;
    }

    @DisplayName("scheduleService가 싱글톤인지 테스트 ")
    @Test
    public void AppConfigTest_8() {
        testSingleton(config.scheduleService()) ;
    }

    private <T> void testSingleton(T instance) {
        assertThat(instance).isNotNull();
        assertThat(instance).isSameAs(instance);
        assertThat(instance).isInstanceOf(instance.getClass());
    }
}
