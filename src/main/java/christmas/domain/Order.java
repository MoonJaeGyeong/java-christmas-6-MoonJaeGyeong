package christmas.domain;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.restaurant.MenuType;
import christmas.domain.restaurant.Restaurant;
import christmas.util.Parser;
import christmas.util.validate.IllegalArgumentExceptionType;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<String> userOrders_Menu;
    private final List<Integer> userOrders_Count;
    private final  Restaurant restaurant;
    private static final int MINIMUM_ORDER_AMOUNT = 10000;
    private static final int MENU_LIMIT_COUNT = 20;

    public Order(String order_Menu){
        this.userOrders_Menu = new ArrayList<>();
        this.userOrders_Count = new ArrayList<>();
        this.restaurant = new Restaurant();

        SetMenuByUserInput(order_Menu);
        ExceptionAfterOrder();
    }
    public int TotalPrice(){
        int total_Price = 0;
        for(int i=0; i< userOrders_Menu.size(); i++){
            total_Price += restaurant.getPriceOfMenu(userOrders_Menu.get(i)) * userOrders_Count.get(i);
        }
        return total_Price;
    }
    private void SetMenuByUserInput(String order_Menu){
        Parser parser = new Parser();
        List<String> items = parser.parseSplitByCriterion(order_Menu, ",");

        for (String item : items) {
            List<String> parts = parser.parseSplitByCriterion(item, "-");
            validate(parts);
            String food = parts.get(0);
            int quantity = Integer.parseInt(parts.get(1));
            userOrders_Menu.add(food);
            userOrders_Count.add(quantity);
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
        if(userOrders_Menu.contains(input.get(0))){
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
        for(String menu : userOrders_Menu){
            if(restaurant.getMenuTypeOfMenu(menu) == MenuType.BEVERAGE){
                n++;
            }
        }
        if(n == userOrders_Menu.size()){
            throw IllegalArgumentExceptionType.MENU_ONLY_BEVERAGE.getException();
        }
    }

    private void CheckMenuCountOverLimit(){
        int sum = 0;
        for(int quantity : userOrders_Count){
            sum += quantity;
        }

        if(sum > MENU_LIMIT_COUNT){
            throw IllegalArgumentExceptionType.MENU_COUNT_OVER_LIMIT.getException();
        }
    }
}
