package christmas.model;

import java.util.function.Function;

public enum Badge {
    SANTA("산타",price -> price <= -20000),
    TREE("트리",price -> price <= -10000),
    STAR("별",price -> price <= -5000),
    NONE("없음",price -> price > -5000);
    private String badgeName;
    private Function<Integer,Boolean> expression;
    Badge(String badgeName,Function<Integer,Boolean> expression) {
        this.badgeName = badgeName;
        this.expression = expression;
    }

    public Boolean apply(int price) {
        return expression.apply(price);
    }

    public String getBadgeName(){
        return this.badgeName;
    }
}
