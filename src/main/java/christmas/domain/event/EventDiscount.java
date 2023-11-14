package christmas.domain.event;

import static christmas.domain.event.constant.Discount.CHRISTMAS_D_DAY_DISCOUNT;
import static christmas.domain.event.constant.Discount.NOTHING;
import static christmas.domain.event.constant.Discount.SPECIAL_DAY_DISCOUNT;
import static christmas.domain.event.constant.Discount.WEEKDAY_DESSERT_DISCOUNT;
import static christmas.domain.event.constant.Discount.WEEKEND_MAIN_DISCOUNT;

import christmas.domain.Order;
import christmas.domain.VisitDay;
import christmas.domain.restaurant.MenuType;
import christmas.domain.restaurant.Restaurant;
import java.util.HashMap;
import java.util.Map;


public class EventDiscount {
    private final Map<String, Integer> discountInfo;

    private static final int CHRISTMAS_D_DAY_BASIC_DISCOUNT = -1000;
    private static final int MINIMUM_ORDER_AMOUNT = 10000;

    public EventDiscount(VisitDay visitDay, Order order){
        this.discountInfo = new HashMap<>();
        if(order.TotalPrice() >= MINIMUM_ORDER_AMOUNT){
            CalculateDiscount(visitDay, order);
        }

        if(order.TotalPrice() < MINIMUM_ORDER_AMOUNT){
            discountInfo.put(NOTHING.getDiscountName(), NOTHING.getDiscountPrice());
        }
    }

    public Map<String, Integer> getDiscountInfo() {
        return discountInfo;
    }

    public int getTotalDiscountPrice(){
        return discountInfo.values().stream()
                .mapToInt(Integer::intValue).sum();
    }


    private void CalculateDiscount(VisitDay visitDay, Order order){
        ChristmasD_DayDiscount(visitDay);
        WeekDayDiscount(visitDay, order);
        WeekendDiscount(visitDay, order);
        SpecialDayDiscount(visitDay);
    }

    private void ChristmasD_DayDiscount(VisitDay visitDay){
        if(visitDay.isBeforeChristmas()){
            setChristmasD_DayDiscount(visitDay);
        }
    }

    private void setChristmasD_DayDiscount(VisitDay visitDay){
        int discount = visitDay.CalculateDaysToChristmas()
                * CHRISTMAS_D_DAY_DISCOUNT.getDiscountPrice() + CHRISTMAS_D_DAY_BASIC_DISCOUNT;

        discountInfo.put(CHRISTMAS_D_DAY_DISCOUNT.getDiscountName(), discount);
    }

    private void WeekDayDiscount(VisitDay visitDay, Order order){
        if(!visitDay.isWeekend()){
            setWeekDayDiscount(order);
        }
    }

    private void setWeekDayDiscount(Order order){
        int discount = 0;
        Restaurant restaurant = new Restaurant();

        for(String menu : order.getUserOrders().keySet()){
            if(restaurant.getMenuTypeOfMenu(menu) == MenuType.DESSERT){
                discount += WEEKDAY_DESSERT_DISCOUNT.getDiscountPrice() * order.getUserOrders().get(menu);
            }
        }
        discountInfo.put(WEEKDAY_DESSERT_DISCOUNT.getDiscountName(), discount);
    }

    private void WeekendDiscount(VisitDay visitDay, Order order){
        if(visitDay.isWeekend()){
            setWeekendDiscount(order);
        }
    }

    private void setWeekendDiscount(Order order){
        int discount = 0;
        Restaurant restaurant = new Restaurant();

        for(String menu : order.getUserOrders().keySet()){
            if(restaurant.getMenuTypeOfMenu(menu) == MenuType.MAIN){
                discount += WEEKEND_MAIN_DISCOUNT.getDiscountPrice() * order.getUserOrders().get(menu);
            }
        }
        discountInfo.put(WEEKEND_MAIN_DISCOUNT.getDiscountName(),discount);
    }

    private void SpecialDayDiscount(VisitDay visitDay){
        if(visitDay.isStarDay()){
            setSpecialDayDiscount();
        }
    }
    private void setSpecialDayDiscount(){
        discountInfo.put(SPECIAL_DAY_DISCOUNT.getDiscountName(), SPECIAL_DAY_DISCOUNT.getDiscountPrice());
    }
}
