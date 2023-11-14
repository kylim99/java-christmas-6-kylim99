package christmas.util;

import christmas.model.Food;
import christmas.model.Menu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuValidator extends Validator{
    private final String regex = "^([가-힣]+-\\d+,)*[가-힣]+-\\d+$";
    private final Menu menu = new Menu();
    @Override
    public boolean validation(String input) {
        if(isNotValidFormat(input)){
            System.out.println("형태가 아님");
            return false;
        }
        if(validationManager(input)){
            System.out.println("메뉴에 없음");
            return false;
        }
        if(isDuplicate(input)){
            System.out.println("중복 주문");
            return false;
        }
        return true;
    }


    private static boolean isDuplicate(String input) {

        Pattern pattern = Pattern.compile("([가-힣]+)-\\d+");
        Matcher matcher = pattern.matcher(input);

        List<String> menus = Arrays.asList(input.split(","));

        return menus.stream()
                .map(menu -> matcher.reset(menu).matches() ? matcher.group(1) : null)
                .filter(menu -> menu != null)
                .distinct()
                .count() != menus.size();
    }


    private boolean validationManager(String input) {
        List<String> inputMenu = Arrays.asList(input.split(","));
        return inputMenu.stream()
                .anyMatch(order ->
                        isOrderZero(order.split("-")[1])|| isNotInMenu(order.split("-")[0])
                );
    }

    private boolean isOrderZero(String input) {
        int amount = Integer.parseInt(input);
        return amount == 0;
    }

    private boolean isNotInMenu(String order) {
        return !menu.getMenus().stream()
                .anyMatch(food -> food.getName().equals(order));
    }

    private boolean isNotValidFormat(String input) {
        System.out.println(input.matches(regex));
        return !input.matches(regex);
    }


}
