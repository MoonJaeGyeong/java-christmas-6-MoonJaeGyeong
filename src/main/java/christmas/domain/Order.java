package christmas.domain;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.restaurant.MenuType;
import christmas.domain.restaurant.Restaurant;
import christmas.util.Parser;
import christmas.util.validate.IllegalArgumentExceptionType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private final Map<String, Integer> userOrders;
    private final  Restaurant restaurant;
    private static final int MENU_LIMIT_COUNT = 20;

    public Order(String order_Menu){
        this.userOrders = new HashMap<>();
        this.restaurant = new Restaurant();

        SetMenuByUserInput(order_Menu);
        ExceptionAfterOrder();
    }
    public int TotalPrice(){
        int total_Price = 0;
        for(String menu : userOrders.keySet()){
            total_Price += restaurant.getPriceOfMenu(menu) * userOrders.get(menu);
        }
        return total_Price;
    }

    public Map<String, Integer> getUserOrders(){
        return userOrders;
    }
    private void SetMenuByUserInput(String order_Menu){
        Parser parser = new Parser();
        List<String> items = parser.parseSplitByCriterion(order_Menu, ",");

        for (String item : items) {
            List<String> parts = parser.parseSplitByCriterion(item, "-");
            validate(parts);
            String food = parts.get(0);
            int number = Integer.parseInt(parts.get(1));
            userOrders.put(food, number);
        }
    }

    /* 입력 데이터 유효성 검사 */
    private void validate(List<String> input){
        CheckInputForm(input);
        CheckHasMenu(input);
        CheckCountIsNumeric(input);
        CheckValidNumber(input);
        CheckDuplicateMenu(input);
    }

    private void CheckInputForm(List<String> input){
        if(input.size() != 2){
            throw IllegalArgumentExceptionType.MENU_INPUT_ERROR.getException();
        }
    }

    private void CheckHasMenu(List<String> input){
        if(!restaurant.HasRestaurantMenu(input.get(0))){
            throw IllegalArgumentExceptionType.MENU_INPUT_ERROR.getException();
        }
    }

    private void CheckCountIsNumeric(List<String> input){
        if(!input.get(1).matches("\\d+")){
            throw IllegalArgumentExceptionType.MENU_INPUT_ERROR.getException();
        }
    }

    private void CheckValidNumber(List<String> input){
        int count = Integer.parseInt(input.get(1));
        if(count < 1){
            throw IllegalArgumentExceptionType.MENU_INPUT_ERROR.getException();
        }
    }

    private void CheckDuplicateMenu(List<String> input){
        if(userOrders.containsKey(input.get(0))){
            throw IllegalArgumentExceptionType.MENU_INPUT_ERROR.getException();
        }
    }

    /* 메뉴가 음료만 있는지, 갯수가 제한을 넘었는지 주문서를 저장 후 검사 진행 */
    private void ExceptionAfterOrder(){
        CheckMenuTypeNotOnlyBEVERAGE();
        CheckMenuCountOverLimit();
    }


    private void CheckMenuTypeNotOnlyBEVERAGE(){
        int n = 0;
        for(String menu : userOrders.keySet()){
            if(restaurant.getMenuTypeOfMenu(menu) == MenuType.BEVERAGE){
                n++;
            }
        }
        if(n == userOrders.size()){
            throw IllegalArgumentExceptionType.MENU_ONLY_BEVERAGE.getException();
        }
    }

    private void CheckMenuCountOverLimit(){
        int sum = 0;
        for(String menu : userOrders.keySet()){
            sum += userOrders.get(menu);
        }

        if(sum > MENU_LIMIT_COUNT){
            throw IllegalArgumentExceptionType.MENU_COUNT_OVER_LIMIT.getException();
        }
    }
}
