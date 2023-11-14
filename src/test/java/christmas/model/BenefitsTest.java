package christmas.model;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class BenefitsTest {

    @Test
    void 해택_적용_태스트(){
        int date = 3;  //크리스마스 할인 1200원
        Week week = Week.SUNDAY;//특별할인 1000원
        Food food = new Food("티본스테이크",55000,Type.MAIN);//디저트가 없음으로 평일할인 X
        Map<Food, Integer> order = new HashMap<>();
        order.put(food,2);
        ConfirmOrder confirmOrder = new ConfirmOrder(order,date,week);

        Benefits benefits = new Benefits(confirmOrder);

        assertThat(benefits.getBenefitPrice()).isEqualTo(-2200);
        assertThat(benefits.toString()).contains("크리스마스 디데이 할인: -1,200원","특별 할인: -1,000원");
        assertThat(benefits.toString()).doesNotContain("평일 할인:");
    }
}
