package christmas.domain.entity;

import static christmas.configuration.IntegerConstant.MIN_PRICE;

import christmas.domain.entity.discount.MyDiscount;
import java.util.Map;

public class Promotion {
    private final MyDiscount myDiscount;
    private final MyGiveaway myGiveaway;
    private final MyEventBadge myEventBadge;
    private final int totalBenefit;

    private Promotion(VisitDate visitDate, Orders orders) {
        myDiscount = MyDiscount.create(visitDate, orders);
        myGiveaway = MyGiveaway.create(orders.getTotalPrice());
        totalBenefit = calcTotalBenefit();
        myEventBadge = MyEventBadge.create(totalBenefit);
    }

    public static Promotion create(VisitDate visitDate, Orders orders) {
        if(orders.getTotalPrice() < MIN_PRICE.getValue()) {
            return null;
        }
        return new Promotion(visitDate, orders);
    }

    private int calcTotalBenefit() {
        int allDiscount = myDiscount.getAllDiscount();
        return allDiscount + calcGiveawayBenefit();
    }

    private int calcGiveawayBenefit() {
        int result = 0;
        Map<Menu, Integer> giveaways =  myGiveaway.getAvailableGiveaway();
        for(Menu menu : giveaways.keySet()) {
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
