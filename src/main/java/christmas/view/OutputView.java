package christmas.view;

import christmas.view.constant.ConstantMessage;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class OutputView {
    public static final NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.KOREA);

    private final static String SPACE = " ";
    private final static String EA = "개";
    private final static String WON = "원";
    private final static String NOTHING = "없음";


    public void printErrorMessage(String errorMessage){
        System.out.println(errorMessage);
    }
    public static void printGreetings(){
        printlnConstantMessage(ConstantMessage.Greetings);
    }
    public static void printEventGuidelines(){
        printlnConstantMessage(ConstantMessage.GUIDE_LINE);
    }

    public static void printEventBenefitNotice(int day){
        printfConstantMessage(ConstantMessage.EVENT_MONTH);
        System.out.printf(SPACE + day);
        printlnConstantMessage(ConstantMessage.EVENT_INFORMATION);
    }

    public static void printOrderMenu(Map<String, Integer> order_Menu){
        printNewLine();
        printlnConstantMessage(ConstantMessage.ORDER_MENU);
        for(String menu : order_Menu.keySet()){
            System.out.println(menu + SPACE + order_Menu.get(menu).toString() + EA);
        }
        printNewLine();
    }

    public static void printTotalPriceBeforeDiscount(int price){
        printlnConstantMessage(ConstantMessage.TOTAL_PRICE_BEFORE_DISCOUNT);
        System.out.println(PriceAfterFormating(price) + WON);
        printNewLine();
    }

    public static void printPresentationMenu(String presentation){
        printlnConstantMessage(ConstantMessage.PRESENTATION_MENU);
        System.out.println(presentation);
        printNewLine();
    }

    public static void printBenefitInfo(Map<String, Integer> BenefitInfo){
        printlnConstantMessage(ConstantMessage.BENEFIT_DETAILS);
        for(String discountName : BenefitInfo.keySet()){
            if(discountName.equals(NOTHING)){
                System.out.println(NOTHING);
            }
            if(!discountName.equals(NOTHING)){
                String amount = PriceAfterFormating(BenefitInfo.get(discountName));
                System.out.println(discountName + amount + WON);
            }
        }
        printNewLine();
    }

    public static void printTotalBenefitPrice(int price){
        printlnConstantMessage(ConstantMessage.TOTAL_BENEFIT_PRICE);
        System.out.println(PriceAfterFormating(price) + WON);
        printNewLine();
    }

    public static void printTotalPriceAfterDiscount(int price){
        printlnConstantMessage(ConstantMessage.TOTAL_PRICE_AFTER_DISCOUNT);
        System.out.println(PriceAfterFormating(price) + WON);
        printNewLine();
    }

    public static void printEventBadge(String event_Badge){
        printlnConstantMessage(ConstantMessage.EVENT_BADGE);
        System.out.println(event_Badge);
        printNewLine();
    }

    private static String PriceAfterFormating(int price){
        String amount = numberFormat.format(price);
        amount = amount.replace("₩", "");
        return amount;
    }

    private static void printlnConstantMessage(ConstantMessage constantMessage){
        System.out.println(constantMessage.getMessage());
    }

    private static void printfConstantMessage(ConstantMessage constantMessage){
        System.out.printf(constantMessage.getMessage());
    }
    private static void printNewLine() {
        System.out.println();
    }
}
