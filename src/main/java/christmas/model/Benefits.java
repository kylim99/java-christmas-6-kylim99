package christmas.model;

import java.util.Map;

public class Benefits {

    private int benefitPrice;
    public Benefits(ConfirmOrder confirmOrder){
        applyDayBenefit(confirmOrder);
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
