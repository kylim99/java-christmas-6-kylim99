package christmas.controller;


import christmas.model.Week;
import christmas.view.InputView;
import christmas.view.OutputView;


public class ChristmasApplication {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run(){
        int date = getDate();
        Week value = getWeek(date);
    }

    private Week getWeek(int date) {
        return Week.values()[date % 7];
    }

    private int getDate(){
        outputView.printWelcomeMessage();
        return inputView.readDate();
    }
}
