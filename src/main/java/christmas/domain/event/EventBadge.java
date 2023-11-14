package christmas.domain.event;

import static christmas.domain.event.constant.Badge.NOTHING;

import christmas.domain.event.constant.Badge;

public class EventBadge {
    private final String badge;


    public EventBadge(int total_Discount){
        badge = SelectBadgeByDiscountPrice(total_Discount);
    }

    public String getBadge() {
        return badge;
    }

    private String SelectBadgeByDiscountPrice(int total_Discount){
        total_Discount = Math.abs(total_Discount);
        if(total_Discount >= Badge.SANTA.getDiscount_Price()){
            return Badge.SANTA.getBadge();
        }
        if(total_Discount >= Badge.TREE.getDiscount_Price()){
            return Badge.TREE.getBadge();
        }
        if(total_Discount >= Badge.STAR.getDiscount_Price()){
            return Badge.STAR.getBadge();
        }
        return NOTHING.getBadge();
    }
}
