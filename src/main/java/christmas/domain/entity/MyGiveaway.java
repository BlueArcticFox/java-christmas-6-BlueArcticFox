package christmas.domain.entity;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class MyGiveaway {
    private final Map<Giveaway, Boolean> giveawayAvailable = new EnumMap<>(Giveaway.class);

    public MyGiveaway(int value) {
        decideGiveawayAvailable(value);
    }

    private void decideGiveawayAvailable(int value) {
        for(Giveaway condition : Giveaway.values()) {
            giveawayAvailable.put(
                    condition,
                    condition.satisfyCondition(value));
        }
    }

    public List<Menu> getAvailableGiveaway() {
        List<Menu> myGiveaways = new ArrayList<>();
        for(Giveaway giveaway : Giveaway.values()) {
            if(giveawayAvailable.get(giveaway)) {
                myGiveaways.add(giveaway.getMenu());
            }
        }
        return myGiveaways;
    }
}
