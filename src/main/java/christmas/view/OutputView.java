package christmas.view;

import christmas.model.Badge;
import christmas.model.Benefits;
import christmas.model.ConfirmOrder;
import christmas.model.Present;
import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;

public class OutputView {
    DecimalFormat decFormat = new DecimalFormat("###,###");
    private final String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private final String INIT_ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private final String INIT_BENEFIT_MESSAGE = "<혜택 내역>";
    private final String INIT_TOTAL_PRICE = "<할인 전 총주문 금액>";
    private final String INIT_PRESENT_MESSAGE = "<증정 메뉴>";
    private final String INIT_TOTAL_BENEFIT_MESSAGE = "<총혜택 금액>";
    private final String INIT_AFTER_TOTAL_PRICE_MESSAGE = "<할인 후 예상 결제 금액>";
    private final String ORDER_MENU_MESSAGE = "%s %d개";
    private final String PREVIEW_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

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

    public void printPreviewMessage() {
        System.out.println();
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
