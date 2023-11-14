package christmas.util;

public class DateValidator extends Validator{

    @Override
    public boolean validation(String input) {
        if(isNotNumeric(input)){
            return false;
        }
        return true;
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
