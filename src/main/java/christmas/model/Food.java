package christmas.model;

public class Food {
    private final String name;
    private final int price;
    private final Type type;

    public Food(String name,int price,Type type){
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName(){
        return this.name;
    }
    public int getPrice(){
        return this.price;
    }

    public Type getType() {
        return type;
    }
}
