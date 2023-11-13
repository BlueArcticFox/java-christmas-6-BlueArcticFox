package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.entity.EventBadge;
import christmas.domain.entity.MyEventBadge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyEventBadgeTest {
    @DisplayName("산타 뱃지 테스트")
    @Test
    void testBadge_1() {
        MyEventBadge myBadge = new MyEventBadge(20000);
        assertEquals(myBadge.getBadge(), EventBadge.SANTA_BADGE);
    }

    @DisplayName("트리 뱃지 테스트")
    @Test
    void testBadge_2() {
        MyEventBadge myBadge = new MyEventBadge(19999);
        assertEquals(myBadge.getBadge(), EventBadge.TREE_BADGE);
    }

    @DisplayName("별 뱃지 테스트")
    @Test
    void testBadge_3() {
        MyEventBadge myBadge = new MyEventBadge(9999);
        assertEquals(myBadge.getBadge(), EventBadge.STAR_BADGE);
    }

    @DisplayName("No 뱃지 테스트")
    @Test
    void testBadge_4() {
        MyEventBadge myBadge = new MyEventBadge(4999);
        assertEquals(myBadge.getBadge(), EventBadge.NULL_BADGE);
    }
}
