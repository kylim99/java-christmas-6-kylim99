package christmas.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Order {
    private Map<String,Integer> orderSheet = new HashMap<>();

    public Order(String input){
        List<String> order = Arrays.stream(input.split(",")).toList();
        putOrder(order);
    }

    private void putOrder(List<String> orders) {
        this.orderSheet = orders.stream()
                .map(order -> order.split("-"))
                .collect(Collectors.toMap(
                        splitOrder -> splitOrder[0],
                        splitOrder -> Integer.parseInt(splitOrder[1])
                ));
    }

    public Map<String,Integer> getOrderSheet(){
        return this.orderSheet;
    }
}
