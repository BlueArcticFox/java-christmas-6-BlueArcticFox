package christmas.domain.entity;

import static christmas.message.BenefitMessage.GIVEAWAY_EVENT_MESSAGE;

import java.util.EnumMap;
import java.util.Map;

public class MyGiveaway {
    private final Map<Giveaway, Boolean> giveawayAvailable = new EnumMap<>(Giveaway.class);

    private MyGiveaway(int value) {
        decideGiveawayAvailable(value);
    }

    public static MyGiveaway create(int value) {
        return new MyGiveaway(value);
    }

    private void decideGiveawayAvailable(int value) {
        for(Giveaway condition : Giveaway.values()) {
            giveawayAvailable.put(
                    condition,
                    condition.satisfyCondition(value));
        }
    }

    public Map<Menu, Integer> getAvailableGiveaway() {
        Map<Menu, Integer> myGiveaways = new EnumMap<>(Menu.class);
        for(Giveaway giveaway : Giveaway.values()) {
            if(giveawayAvailable.get(giveaway)) {
                myGiveaways.put(giveaway.getMenu(), giveaway.getQuantity());
            }
        }
        return myGiveaways;
    }

    public String getMessage() {
        return GIVEAWAY_EVENT_MESSAGE.getMessage();
    }
}
