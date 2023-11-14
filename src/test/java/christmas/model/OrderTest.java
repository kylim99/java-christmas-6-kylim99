package christmas.model;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    void 입력을_order로_바꾸는_테스트(){
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Order order = new Order(input);
        assertThat(order.getOrderSheet().get("티본스테이크")).isEqualTo(1);
        assertThat(order.getOrderSheet().get("바비큐립")).isEqualTo(1);
        assertThat(order.getOrderSheet().get("초코케이크")).isEqualTo(2);
        assertThat(order.getOrderSheet().get("제로콜라")).isEqualTo(1);

    }

}
