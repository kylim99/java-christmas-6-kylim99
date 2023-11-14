package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.DateValidator;
import java.util.HashMap;

public class InputView {

    private final String DATE_INPUT_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private final String MENU_INPUT_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    private final DateValidator dateValidator = new DateValidator();

    public int readDate() {
        System.out.println(DATE_INPUT_MESSAGE);
        String input;
        do {
            input = Console.readLine();
        }while (!dateValidator.validation(input));
        return Integer.parseInt(input);
    }

    public String readMenu(){
        System.out.println(MENU_INPUT_MESSAGE);
        return Console.readLine();
    }


}
