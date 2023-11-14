package christmas.domain;

import christmas.domain.restaurant.MenuType;
import christmas.domain.restaurant.Restaurant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User {
    private final Order order;
    private final VisitDay visitDay;

    public User(Order order, VisitDay visitDay){
        this.order = order;
        this.visitDay = visitDay;
    }

    public Order getOrder() {
        return order;
    }

    public VisitDay getVisitDay() {
        return visitDay;
    }
}
