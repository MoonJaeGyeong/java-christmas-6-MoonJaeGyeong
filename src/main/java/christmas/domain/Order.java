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
    private static final int MINIMUM_ORDER_AMOUNT = 10000;
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

    private void validate(List<String> input){
        CheckInputForm(input);
        CheckHasMenu(input);
        checkQuantityIsNumeric(input);
        checkDuplicateMenu(input);
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

    private void checkQuantityIsNumeric(List<String> input){
        if(!input.get(1).matches("\\d+")){
            throw IllegalArgumentExceptionType.MENU_INPUT_ERROR.getException();
        }
    }

    private void checkDuplicateMenu(List<String> input){
        if(userOrders.containsKey(input.get(0))){
            throw IllegalArgumentExceptionType.MENU_INPUT_ERROR.getException();
        }
    }

    private void ExceptionAfterOrder(){
        // 10,000원 이하 일 시
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
