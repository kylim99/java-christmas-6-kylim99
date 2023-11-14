package christmas.view;

import static christmas.util.constatnt.Constant.*;

import christmas.model.Badge;
import christmas.model.Benefits;
import christmas.model.ConfirmOrder;
import christmas.model.Present;

public class OutputView {


    public void printWelcomeMessage(){
        System.out.println(WELCOME_MESSAGE);
    }

    public void printOrderInformation(ConfirmOrder confirmOrder) {
        System.out.println(String.format(PREVIEW_MESSAGE,confirmOrder.getDate()));
        System.out.println();
        System.out.println(INIT_ORDER_MENU_MESSAGE);
        confirmOrder.getConfirmOrder()
                .forEach((food, quantity) -> {
                    System.out.println(String.format(ORDER_MENU_MESSAGE, food.getName(), quantity));
        });
        System.out.println();
        printTotalPriceBeforeEvent(confirmOrder);
    }

    private void printTotalPriceBeforeEvent(ConfirmOrder confirmOrder) {
        System.out.println(INIT_TOTAL_PRICE);
        System.out.println(decFormat.format(confirmOrder.getTotalPrice())+"원");
    }

    public void printBenefit(Benefits benefits,Present present) {
        System.out.println();
        System.out.println(INIT_BENEFIT_MESSAGE);
        System.out.print(benefits);
        System.out.println(present.getPresentLog());
    }

    public void printpresent(Present present) {
        System.out.println();
        System.out.println(INIT_PRESENT_MESSAGE);
        System.out.println(present.getPresent());
    }

    public void printTotalBenefitPrice(int totalBenefitPrice) {
        System.out.println();
        System.out.println(INIT_TOTAL_BENEFIT_MESSAGE);
        System.out.println(decFormat.format(totalBenefitPrice) + "원");
    }

    public void printAfterEventPrice(int price) {
        System.out.println();
        System.out.println(INIT_AFTER_TOTAL_PRICE_MESSAGE);
        System.out.println(decFormat.format(price) + "원");
    }

    public void printBadge(Badge badge) {
        System.out.println();
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge.getBadgeName());
    }
}
