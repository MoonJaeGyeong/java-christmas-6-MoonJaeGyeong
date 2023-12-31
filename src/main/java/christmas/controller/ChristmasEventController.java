package christmas.controller;

import christmas.domain.Order;
import christmas.domain.VisitDay;
import christmas.domain.event.EventBenefit;
import christmas.util.Iterator;
import christmas.view.InputView;
import christmas.view.OutputView;


public class ChristmasEventController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Iterator iterator; // 클래스 생성 실패 시 반복 시키는 클래스

    private static final int MINIMUM_AMOUNT_FOR_EVENT = 10000;

    public ChristmasEventController(InputView inputView, OutputView outputView, Iterator iterator){
        this.inputView = inputView;
        this.outputView = outputView;
        this.iterator = iterator;
    }
    public void run(){
        outputView.printGreetings();
        VisitDay visitDay = getVisitDay();
        Order order = getOrder();

        outputView.printEventBenefitNotice(visitDay.getDay());
        printMenuAndTotalPrice(order);
        JoinEvent(visitDay,order);
    }

    private void printMenuAndTotalPrice(Order order){
        int total_Price = order.TotalPrice();

        if(total_Price < MINIMUM_AMOUNT_FOR_EVENT){
            outputView.printEventGuidelines();
        }

        outputView.printOrderMenu(order.getUserOrders());
        outputView.printTotalPriceBeforeDiscount(total_Price);
    }

    private void JoinEvent(VisitDay visitDay, Order order){
        EventBenefit eventBenefit = new EventBenefit(visitDay, order);

        printBenefitInfo(order,eventBenefit);
    }

    private void printBenefitInfo(Order order, EventBenefit eventBenefit){
        outputView.printPresentationMenu(eventBenefit.getPresentation());
        outputView.printBenefitInfo(eventBenefit.getBenefitInfo());
        outputView.printTotalBenefitPrice(eventBenefit.getTotalBenefitPrice());
        outputView.printTotalPriceAfterDiscount(order.TotalPrice() + eventBenefit.getTotalDiscountPrice());
        outputView.printEventBadge(eventBenefit.getBadge());
    }

    private VisitDay getVisitDay(){
        return iterator.iterate(() -> new VisitDay(inputView.RequestDayByUserInput()));
    }

    private Order getOrder(){
        return iterator.iterate( () -> new Order(inputView.RequestMenuByUserInput()));
    }

}
