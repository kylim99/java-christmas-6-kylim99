package christmas.controller;


import christmas.model.Benefits;
import christmas.model.ConfirmOrder;
import christmas.model.Food;
import christmas.model.Order;
import christmas.model.Week;
import christmas.model.Menu;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ChristmasApplication {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Menu menu = new Menu();

    public void run(){
        int date = getDate();
        Week week = getWeek(date);
        Order order = getOrder();
        ConfirmOrder confirmOrder = new ConfirmOrder(makeOrderSheet(order),date,week);
        printOrderInformation(confirmOrder);
        applyBenefits(confirmOrder);
    }

    private void applyBenefits(ConfirmOrder confirmOrder) {
        outputView.printBenefitTitle();
        Benefits benefits = new Benefits(confirmOrder);
    }

    private void printOrderInformation(ConfirmOrder confirmOrder) {
        outputView.printOrderInformation(confirmOrder);
    }

    private Map<Food, Integer> makeOrderSheet(Order order) {
        Map<Food, Integer> confirmOrder = createConfirmOrder(menu.getMenus(), order.getOrderSheet());
        return confirmOrder;
    }
    private Map<Food, Integer> createConfirmOrder(List<Food> menus, Map<String, Integer> orderSheet) {
        return menus.stream()
                .filter(f -> orderSheet.containsKey(f.getName()))
                .collect(Collectors.toMap(
                        f -> f,
                        f -> orderSheet.get(f.getName())
                ));
    }

    private Order getOrder(){
        String input = inputView.readMenu();
        return new Order(input);
    }

    private Week getWeek(int date) {
        return Week.values()[date % 7];
    }

    private int getDate(){
        outputView.printWelcomeMessage();
        return inputView.readDate();
    }
}
