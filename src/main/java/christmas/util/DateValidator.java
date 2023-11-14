package christmas.util;

public class DateValidator extends Validator{

    @Override
    public boolean validation(String input) {
        if(isNotNumeric(input)){
            return false;
        }
        if(hasBlank(input)){
            return false;
        }
        if(isNotInRange(input)){
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
            return false;
        }
    }
}
