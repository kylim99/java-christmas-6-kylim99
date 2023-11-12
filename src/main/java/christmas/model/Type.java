package christmas.model;

public enum Type {
    APPETIZER("에피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    BEVERAGE("음료");
    private final String type;
    Type(String type){
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
