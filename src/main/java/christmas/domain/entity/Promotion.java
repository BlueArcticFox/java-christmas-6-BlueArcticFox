package christmas.domain.entity;

import christmas.domain.entity.discount.MyDiscount;
import java.util.List;

public class Promotion {
    private final MyDiscount myDiscount;
    private final MyGiveaway myGiveaway;
    private final MyEventBadge myEventBadge;
    private final int totalBenefit;

    public Promotion(VisitDate visitDate, Orders orders) {
        myDiscount = new MyDiscount(visitDate, orders);
        myGiveaway = new MyGiveaway(orders.getTotalPrice());
        totalBenefit = calcTotalBenefit();
        myEventBadge = new MyEventBadge(totalBenefit);
    }

    private int calcTotalBenefit() {
        int allDiscount = myDiscount.getAllDiscount();
        return allDiscount + calcGiveawayBenefit();
    }

    private int calcGiveawayBenefit() {
        int result = 0;
        List<Menu> giveaways =  myGiveaway.getAvailableGiveaway();
        for(Menu menu : giveaways) {
            result += menu.getPrice();
        }
        return result;
    }

    public MyDiscount getMyDiscount() {
        return myDiscount;
    }

    public MyGiveaway getMyGiveaway() {
        return myGiveaway;
    }

    public MyEventBadge getMyEventBadge() {
        return myEventBadge;
    }

    public int getTotalBenefit() {
        return totalBenefit;
    }
}
