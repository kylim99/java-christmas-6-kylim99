package christmas.util.validation;

import christmas.util.ExceptionMessage;

public class DateValidator extends Validator {

    @Override
    public boolean validation(String input) {
        if(isNotNumeric(input)){
            System.out.println(ExceptionMessage.INVALID_DATE_INPUT.getMessage());
            return false;
        }
        if(hasBlank(input)){
            System.out.println(ExceptionMessage.INVALID_DATE_INPUT.getMessage());
            return false;
        }
        if(isNotInRange(input)){
            System.out.println(ExceptionMessage.INVALID_DATE_INPUT.getMessage());
            return false;
        }
        return true;
    }

    private boolean isNotInRange(String input) {
        int date = Integer.parseInt(input);
        return date < 1 || date > 31;
    }

    private boolean hasBlank(String input) {
        return input.contains(" ");
    }

    private boolean isNotNumeric(String input) {
        try {
            Integer.parseInt(input);
            return false;
        }catch (NumberFormatException exception){
            return true;
        }
    }
}
