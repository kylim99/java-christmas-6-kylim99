package christmas.util;

public class MenuValidator extends Validator{
    private final String regex = "^([가-힣]+-\\d+,)*[가-힣]+-\\d+$";
    @Override
    public boolean validation(String input) {
        if(isNotValidFormat(input)){
            return false;
        }
        return true;
    }

    private boolean isNotValidFormat(String input) {
        return !input.matches(regex);
    }


}
