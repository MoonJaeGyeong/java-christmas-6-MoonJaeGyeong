package christmas.domain.event;

public class EventBadge {
    private final String badge;
    private static final String NOTHING = "없음";

    public EventBadge(int total_Discount){
        badge = SelectBadgeByDiscountPrice(total_Discount);
    }

    private String SelectBadgeByDiscountPrice(int total_Discount){
        if(total_Discount >= Badge.SANTA.getDiscount_Price()){
            return Badge.SANTA.getBadge();
        }
        if(total_Discount >= Badge.TREE.getDiscount_Price()){
            return Badge.TREE.getBadge();
        }
        if(total_Discount >= Badge.STAR.getDiscount_Price()){
            return Badge.STAR.getBadge();
        }
        return NOTHING;
    }
}
