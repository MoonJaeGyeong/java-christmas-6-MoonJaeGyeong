package christmas;

import christmas.controller.ChristmasEventController;

import christmas.util.Iterator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Iterator iterator = new Iterator(outputView::printErrorMessage);
        ChristmasEventController christmasEventController =
                new ChristmasEventController(inputView, outputView, iterator);

        christmasEventController.run();
    }
}
