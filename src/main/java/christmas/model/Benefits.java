package christmas.model;

import static christmas.util.constatnt.Constant.decFormat;

import java.util.Map;

public class Benefits {

    private int benefitPrice = 0;
    private StringBuilder benefitLog = new StringBuilder("없음");
    public Benefits(ConfirmOrder confirmOrder){
        if(confirmPrice(confirmOrder)){
            benefitLog = new StringBuilder();
            applyDayBenefit(confirmOrder);
            applyWeekendBenefit(confirmOrder);
            applyWeekdayBenefit(confirmOrder);
            applySpecialDayBenefit(confirmOrder);
        }
    }

    private boolean confirmPrice(ConfirmOrder confirmOrder) {
        int total =confirmOrder.getConfirmOrder().entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
        return total > 10000;
    }

    private void applySpecialDayBenefit(ConfirmOrder confirmOrder) {
        if(isSpecialDay(confirmOrder.getWeek(),confirmOrder.getDate())){
            benefitPrice -= 1000;
            benefitLog.append("특별 할인: -1,000원\n");
        }
    }

    private boolean isSpecialDay(Week week, int date) {
        if(date == 25 || week.equals(Week.SUNDAY)){
            return true;
        }
        return false;
    }

    private void applyWeekdayBenefit(ConfirmOrder confirmOrder) {
        if(!isWeekend(confirmOrder.getWeek()) && isOrderHasDesset(confirmOrder)){
            addBenefitPricePerDessert(confirmOrder.getConfirmOrder());
        }
    }

    private boolean isOrderHasDesset(ConfirmOrder confirmOrder) {
        return confirmOrder.getConfirmOrder().keySet().stream().anyMatch(food -> food.getType() == Type.DESSERT);
    }

    private void addBenefitPricePerDessert(Map<Food, Integer> confirmOrder) {
        int benefit = confirmOrder.entrySet().stream()
                .filter(entry -> entry.getKey().getType() == Type.DESSERT)
                .mapToInt(entry -> 2023 * entry.getValue())
                .sum();
        benefitPrice -= benefit;
        benefitLog.append(String.format("평일 할인: -%s원\n",decFormat.format(benefit)));
    }

    private void applyWeekendBenefit(ConfirmOrder confirmOrder) {
        if(isWeekend(confirmOrder.getWeek()) && isOrderHasMain(confirmOrder)){
            addBenefitPricePerMain(confirmOrder.getConfirmOrder());
        }
    }

    private boolean isOrderHasMain(ConfirmOrder confirmOrder) {
        return confirmOrder.getConfirmOrder().keySet().stream().anyMatch(food -> food.getType() == Type.MAIN);
    }

    private void addBenefitPricePerMain(Map<Food, Integer> confirmOrder) {
        int benefit = confirmOrder.entrySet().stream()
                .filter(entry -> entry.getKey().getType() == Type.MAIN)
                .mapToInt(entry -> 2023 * entry.getValue())
                .sum();
        benefitPrice -= benefit;
        benefitLog.append(String.format("주말 할인: -%s원\n",decFormat.format(benefit)));
    }

    private boolean isWeekend(Week week) {
        return week.equals(Week.FRIDAY) || week.equals(Week.SATURDAY);
    }

    private void applyDayBenefit(ConfirmOrder confirmOrder) {
        if(isInDayBenefitPeriod(confirmOrder.getDate())){
            int benefit = (confirmOrder.getDate() - 1) * 100 + 1000;
            benefitPrice -= benefit;
            benefitLog.append(String.format("크리스마스 디데이 할인: -%s원\n", decFormat.format(benefit)));
        }
    }

    private boolean isInDayBenefitPeriod(int date) {
        return 1 <= date && date <= 25;
    }

    @Override
    public String toString() {
        return benefitLog.toString();
    }

    public int getBenefitPrice() {
        return benefitPrice;
    }
}
