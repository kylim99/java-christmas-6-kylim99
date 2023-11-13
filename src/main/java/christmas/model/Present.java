package christmas.model;

public class Present {
    private int presentPrice;
    private StringBuilder presentLog= new StringBuilder();
    private StringBuilder present = new StringBuilder("없음");

    public Present(ConfirmOrder confirmOrder){
        if(confirmPrice(confirmOrder)){
            presentPrice = 25000;
            presentLog.append("증정 이벤트: -25,000원");
            present = new StringBuilder("샴페인 1개");
        }
    }

    private boolean confirmPrice(ConfirmOrder confirmOrder) {
        int total =confirmOrder.getConfirmOrder().entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
        return total > 120000;
    }

    public String getPresentLog(){
        return presentLog.toString();
    }

    public String getPresent() {
        return present.toString();
    }

    public int getPresentPrice() {
        return presentPrice;
    }
}
