package christmas.model;

public class Present {
    private int presentPrice;
    private StringBuilder presentLog;

    public Present(ConfirmOrder confirmOrder){
        if(confirmPrice(confirmOrder)){
            presentPrice = 25000;
            presentLog = new StringBuilder("샴페인 1개");
        }else {
            presentLog = new StringBuilder("없음");
        }

    }

    private boolean confirmPrice(ConfirmOrder confirmOrder) {
        int total =confirmOrder.getConfirmOrder().entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
        return total > 120000;
    }
}
