package christmas.model;

import christmas.view.InputView;
import java.util.Map;

public class Benefits {

    private int benefitPrice = 0;
    public Benefits(ConfirmOrder confirmOrder){
        applyDayBenefit(confirmOrder);
        applyWeekendBenefit(confirmOrder);
        applyWeekdayBenefit(confirmOrder);
        applySpecialDayBenefit(confirmOrder);
        confirmPrice(confirmOrder);
    }

    private void confirmPrice(ConfirmOrder confirmOrder) {
        int total =confirmOrder.getConfirmOrder().entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
        if(total < 10000){
            benefitPrice = 0;
        }
    }

    private void applySpecialDayBenefit(ConfirmOrder confirmOrder) {
        if(isSpecialDay(confirmOrder.getWeek(),confirmOrder.getDate())){
            benefitPrice += 1000;
        }
    }

    private boolean isSpecialDay(Week week, int date) {
        if(date == 25){
            return true;
        }
        if(week.equals(Week.SUNDAY)){
            return true;
        }
        return false;
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
        return 1 <= date && date <= 25;
    }

    public int getBenefitPrice() {
        return benefitPrice;
    }
}
