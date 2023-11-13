package christmas;

import christmas.controller.ChristmasEventController;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ChristmasEventController christmasEventController = new ChristmasEventController(inputView, outputView);

        christmasEventController.run();
    }
}
