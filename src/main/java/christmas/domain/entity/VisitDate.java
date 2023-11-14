package christmas.domain.entity;

import static christmas.configuration.DateConstant.DECEMBER_FIRST_WEEK_WEIGHT;
import static christmas.configuration.DateConstant.WEEKS_NUMBER;

import christmas.validation.VisitDateValidator;

public class VisitDate extends VisitDateValidator {
    private final int date;
    private final int week;

    private VisitDate(int date) {
        validateDate(date);
        this.date = date;
        week = decideWeek();
    }

    public static VisitDate create(int date) {
        return new VisitDate(date);
    }

    public int decideWeek() {
        int weight = date + DECEMBER_FIRST_WEEK_WEIGHT.getValue();
        return weight % WEEKS_NUMBER.getValue();
    }

    public int getDate() {
        return date;
    }
    public int getWeek() {
        return week;
    }
}
