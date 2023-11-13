package christmas.view;

import christmas.view.constant.ConstantMessage;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;

public class OutputView {
    public static final NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.KOREA);
    private static String SPACE = " ";
    public static void printGreetings(){
        printConstantMessage(ConstantMessage.Greetings);
    }

    public static void printOrderMenu(HashMap<String, Integer> order_Menu){
        printConstantMessage(ConstantMessage.ORDER_MENU);
        for(String menu : order_Menu.keySet()){
            System.out.println(menu + SPACE + order_Menu.get(menu).toString());
        }
    }

    public static void printTotalPriceBeforeDiscount(int price){
        printConstantMessage(ConstantMessage.TOTAL_PRICE_BEFORE_DISCOUNT);
        printPriceAfterFormating(price);
    }

    public static void printPresentationMenu(){
        printConstantMessage(ConstantMessage.PRESENTATION_MENU);
    }

    public static void printBenefitDetails(){
        printConstantMessage(ConstantMessage.BENEFIT_DETAILS);
    }

    public static void printTotalBenefitPrice(int price){
        printConstantMessage(ConstantMessage.TOTAL_BENEFIT_PRICE);
        printPriceAfterFormating(price);
    }

    public static void printTotalPriceAfterDiscount(int price){
        printConstantMessage(ConstantMessage.TOTAL_PRICE_AFTER_DISCOUNT);
        printPriceAfterFormating(price);
    }

    public static void printEventBadge(String event_Badge){
        printConstantMessage(ConstantMessage.EVENT_BADGE);
        System.out.println(event_Badge);
    }

    private static void printPriceAfterFormating(int price){
        String amount = numberFormat.format(price);
        System.out.println(amount + "원");
    }

    private static void printConstantMessage(ConstantMessage constantMessage){
        System.out.println(constantMessage.getMessage());
    }
}
