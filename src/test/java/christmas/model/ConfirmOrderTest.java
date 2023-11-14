package christmas.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class ConfirmOrderTest {
    @Test
    void 총금액_테스트(){
        HashMap<Food,Integer> map = new HashMap<>();
        Food food1 = new Food("티본스테이크",55000,Type.MAIN);
        Food food2 = new Food("양송이수프",6000,Type.APPETIZER);
        Food food3 = new Food("레드와인",60000,Type.BEVERAGE);
        map.put(food1,2);
        map.put(food2,2);
        map.put(food3,1);
        ConfirmOrder confirmOrder = new ConfirmOrder(map,3,Week.SUNDAY);
        int totalPrice = confirmOrder.getTotalPrice();
        assertThat(totalPrice).isEqualTo(182000);
    }
}
