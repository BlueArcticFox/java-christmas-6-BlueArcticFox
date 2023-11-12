package christmas.domain.entity;

import christmas.validation.VisitDateValidator;

public class VisitDate extends VisitDateValidator {
    private final int date;

    public VisitDate(int date) {
        validateDate(date);
        this.date = date;
    }

    public int getDate() {
        return date;
    }
}
