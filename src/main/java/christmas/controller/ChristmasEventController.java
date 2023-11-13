package christmas.controller;

import christmas.domain.VisitDay;
import christmas.util.Iterator;
import christmas.view.InputView;
import christmas.view.OutputView;


public class ChristmasEventController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Iterator iterator;

    public ChristmasEventController(InputView inputView, OutputView outputView, Iterator iterator){
        this.inputView = inputView;
        this.outputView = outputView;
        this.iterator = iterator;
    }
    public void run(){
        outputView.printGreetings();
        VisitDay visitDay = getVisitDay();

    }

    private VisitDay getVisitDay(){
        return iterator.iterate(() -> new VisitDay(inputView.RequestDayByUserInput()));
    }
}
