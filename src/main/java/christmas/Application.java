package christmas;

import christmas.controller.ChristmasApplication;
import christmas.model.Menu;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Menu menu = new Menu();
        ChristmasApplication christmasApplication = new ChristmasApplication(inputView, outputView, menu);
        christmasApplication.run();
    }
}
