package christmas.model;

import java.util.Map;

public class ConfirmOrder {
    private final Map<Food, Integer> confirmOrder;
    private final int date;
    private final Week week;


    public ConfirmOrder(Map<Food, Integer> confirmOrder, int date, Week week) {
        this.confirmOrder = confirmOrder;
        this.date = date;
        this.week = week;
    }
    public Map<Food, Integer> getConfirmOrder(){
        return this.confirmOrder;
    }
    public int getDate() {
        return date;
    }

    public Week getWeek() {
        return week;
    }
}
