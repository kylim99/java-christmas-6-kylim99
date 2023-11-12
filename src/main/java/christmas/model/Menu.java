package christmas.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private final String path = "src/main/resources/menu.txt";
    private List<Food> menus = new ArrayList<>();
    public Menu(){
        makeMenu();
    }

    public void makeMenu(){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                Food food = makeFood(line);
                menus.add(food);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Food makeFood(String line) {
        String[] information = line.split("-");
        int price = Integer.parseInt(information[1]);
        Type type = getType(information[2]);
        return new Food(information[0],price,type);
    }
    private Type getType(String type) {
        return  Arrays.stream(Type.values())
                .filter(value -> value.getType().equals(type))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
    public List<Food> getMenus(){
        return this.menus;
    }
}
