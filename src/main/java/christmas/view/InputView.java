package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.constant.ConstantMessage;

public class InputView {
    public static String RequestDayByUserInput(){
        printConstantMessage(ConstantMessage.REQUEST_DAY);
        return Console.readLine();
    }

    public static String RequestMenuByUserInput(){
        printConstantMessage(ConstantMessage.REQUEST_MENU);
        return Console.readLine();
    }
    private static void printConstantMessage(ConstantMessage constantMessage){
        System.out.println(constantMessage.getMessage());
    }
}
