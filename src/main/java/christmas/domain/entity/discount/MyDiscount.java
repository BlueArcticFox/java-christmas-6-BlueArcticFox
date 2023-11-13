package christmas.domain.entity.discount;

import static christmas.configuration.DateConstant.FRIDAY;
import static christmas.configuration.StringConstant.DESSERT;
import static christmas.configuration.StringConstant.MAIN_DISH;

import christmas.domain.entity.Orders;
import christmas.domain.entity.VisitDate;

public class MyDiscount {
    private final D_DayDiscount d_dayDiscount;
    private final SpecialDiscount specialDiscount;
    private final WeekDiscount weekDiscount;

    public MyDiscount(VisitDate visitDate, Orders orders) {
        int date = visitDate.getDate();
        int week = visitDate.getWeek();
        d_dayDiscount = new D_DayDiscount(date);
        specialDiscount = new SpecialDiscount(date, week);
        weekDiscount = decideWeekDiscount(week, orders);
    }

    private WeekDiscount decideWeekDiscount(int week, Orders orders) {
        if (week >= FRIDAY.getValue()) {
            return new WeekendDiscount(orders.getNumberOfSection(MAIN_DISH.getValue()));
        }
        return new WeekdayDiscount(orders.getNumberOfSection(DESSERT.getValue()));
    }

    public D_DayDiscount getD_DayDiscount() {
        return d_dayDiscount;
    }

    public SpecialDiscount getSpecialDiscount() {
        return specialDiscount;
    }

    public WeekDiscount getWeekDiscount() {
        return weekDiscount;
    }

    public int getAllDiscount() {
        return d_dayDiscount.getDiscount() + specialDiscount.getDiscount() + weekDiscount.getDiscount();
    }
}
