package christmas.view;

import christmas.model.ConfirmOrder;
import christmas.model.Food;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class OutputView {
    DecimalFormat decFormat = new DecimalFormat("###,###");
    private final String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private final String INIT_ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private final String INIT_BENEFIT_MESSAGE = "<해택 내역>";
    private final String INIT_TOTAL_PRICE = "<할인 전 총주문 금액>";
    private final String ORDER_MENU_MESSAGE = "%s %d개";

    public void printWelcomeMessage(){
        System.out.println(WELCOME_MESSAGE);
    }

    public void printOrderInformation(ConfirmOrder confirmOrder) {
        AtomicInteger totalPrice = new AtomicInteger();
        System.out.println();
        System.out.println(INIT_ORDER_MENU_MESSAGE);
        confirmOrder.getConfirmOrder().forEach((food, quantity) -> {
            System.out.println(String.format(ORDER_MENU_MESSAGE, food.getName(), quantity));
            totalPrice.addAndGet(food.getPrice() * quantity);
        });
        System.out.println();
        printTotalPriceBeforeEvent(totalPrice);
    }

    private void printTotalPriceBeforeEvent(AtomicInteger price) {
        System.out.println(INIT_TOTAL_PRICE);
        System.out.println(decFormat.format(price)+"원");
    }

    public void printBenefitTitle() {
        System.out.println(INIT_BENEFIT_MESSAGE);
    }
}
