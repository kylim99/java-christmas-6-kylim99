package christmas.model;

import java.util.Map;
import java.util.Map.Entry;

public class Benefits {

    private int benefitPrice;
    public Benefits(ConfirmOrder confirmOrder){
        applyDayBenefit(confirmOrder);
        applyWeekendBenefit(confirmOrder);
        applyWeekdayBenefit(confirmOrder);
    }

    private void applyWeekdayBenefit(ConfirmOrder confirmOrder) {
        if(!isWeekend(confirmOrder.getWeek())){
            addBenefitPricePerDessert(confirmOrder.getConfirmOrder());
        }
    }

    private void addBenefitPricePerDessert(Map<Food, Integer> confirmOrder) {
        benefitPrice += confirmOrder.entrySet().stream()
                .filter(entry -> entry.getKey().getType() == Type.DESSERT)
                .mapToInt(entry -> 2023 * entry.getValue())
                .sum();
    }

    private void applyWeekendBenefit(ConfirmOrder confirmOrder) {
        if(isWeekend(confirmOrder.getWeek())){
            addBenefitPricePerMain(confirmOrder.getConfirmOrder());
        }
    }

    private void addBenefitPricePerMain(Map<Food, Integer> confirmOrder) {
        benefitPrice += confirmOrder.entrySet().stream()
                .filter(entry -> entry.getKey().getType() == Type.MAIN)
                .mapToInt(entry -> 2023 * entry.getValue())
                .sum();
    }

    private boolean isWeekend(Week week) {
        return week.equals(Week.FRIDAY) || week.equals(Week.SATURDAY);
    }

    private void applyDayBenefit(ConfirmOrder confirmOrder) {
        if(isInDayBenefitPeriod(confirmOrder.getDate())){
            benefitPrice += (confirmOrder.getDate() - 1) * 100 + 1000;
        }
    }

    private boolean isInDayBenefitPeriod(int date) {
        return 1 <= date && date <= 31;
    }
}
