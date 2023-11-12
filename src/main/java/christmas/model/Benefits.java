package christmas.model;

import java.util.Map;
import java.util.Map.Entry;

public class Benefits {

    private int benefitPrice;
    public Benefits(ConfirmOrder confirmOrder){
        applyDayBenefit(confirmOrder);
        applyWeekendBenefit(confirmOrder);
    }

    private void applyWeekendBenefit(ConfirmOrder confirmOrder) {
        if(isWeekend(confirmOrder.getWeek())){
            addBenefitPricePerMain(confirmOrder.getConfirmOrder());
        }
    }

    private void addBenefitPricePerMain(Map<Food, Integer> confirmOrder) {
        for(Entry<Food, Integer> entry : confirmOrder.entrySet()){
            if(entry.getKey().getType() == Type.MAIN){
                benefitPrice += 2023 * entry.getValue();
            }
        }
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
