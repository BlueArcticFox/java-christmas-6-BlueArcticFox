package christmas.domain.dto;

import java.util.List;
import java.util.Map;

public class PromotionDto {
    private final Map<String, Integer> giveaway;
    private final Map<String, Integer> benefit;
    private final String badge;

    private PromotionDto(Map<String, Integer> giveaway, Map<String, Integer> benefit, String badge) {
        this.giveaway = giveaway;
        this.benefit = benefit;
        this.badge = badge;
    }

    protected static PromotionDto create(Map<String, Integer> giveaway, Map<String, Integer> benefit, String badge) {
        return new PromotionDto(giveaway, benefit, badge);
    }

    public Map<String, Integer> getGiveaway() {
        return giveaway;
    }

    public Map<String, Integer> getBenefit() {
        return benefit;
    }

    public String getBadge() {
        return badge;
    }
}
