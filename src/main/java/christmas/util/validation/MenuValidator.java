package christmas.util.validation;

import static christmas.util.constatnt.Constant.COMMA;
import static christmas.util.constatnt.Constant.MINUS_SIGN;

import christmas.model.Food;
import christmas.model.Menu;
import christmas.model.Type;
import christmas.util.ExceptionMessage;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MenuValidator extends Validator {
    private final String regex = "^([가-힣]+-\\d+,)*[가-힣]+-\\d+$";
    private final Menu menu = new Menu();
    @Override
    public boolean validation(String input) {
        if(isNotValidFormat(input)){
            System.out.println(ExceptionMessage.INVALID_MENU_INPUT.getMessage());
            return false;
        }
        if(validationManager(input)){
            System.out.println(ExceptionMessage.INVALID_MENU_INPUT.getMessage());
            return false;
        }
        if(isDuplicate(input)){
            System.out.println(ExceptionMessage.INVALID_MENU_INPUT.getMessage());
            return false;
        }
        if(isOnlyBeverage(input)){
            System.out.println(ExceptionMessage.INVALID_MENU_INPUT.getMessage());
            return false;
        }
        if(isOverOrder(input)){
            System.out.println(ExceptionMessage.INVALID_MENU_INPUT.getMessage());
            return false;
        }
        return true;
    }

    private boolean isOverOrder(String input) {
        int count = Arrays.stream(input.split(COMMA))
                .mapToInt(order -> Integer.parseInt(order.split(MINUS_SIGN)[1]))
                .sum();

        return count > 20;
    }

    private boolean isOnlyBeverage(String input) {
        List<String> beverages = menu.getMenus().stream()
                .filter(f -> f.getType() == Type.BEVERAGE)
                .map(Food::getName)
                .collect(Collectors.toList());

        return Arrays.stream(input.split(COMMA))
                .allMatch(order -> beverages.contains(order.split(MINUS_SIGN)[0]));
    }


    private static boolean isDuplicate(String input) {

        Pattern pattern = Pattern.compile("([가-힣]+)-\\d+");
        Matcher matcher = pattern.matcher(input);

        List<String> menus = Arrays.asList(input.split(COMMA));

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
