package christmas.domain.event.constant;

public enum Discount {
    CHRISTMAS_D_DAY_DISCOUNT("크리스마스 디데이 할인: ",-100),
    WEEKDAY_DESSERT_DISCOUNT("평일 할인: " , -2023),
    WEEKEND_MAIN_DISCOUNT("주말 할인: " , -2023),
    SPECIAL_DAY_DISCOUNT("특별 할인: " , -1000),
    PRESENTATION_MENU_DISCOUNT( "증정 이벤트: ", -25000),
    NOTHING("없음", 0);

    private final String discountName;
    private final int discountPrice;

    Discount(String badge, int discount_Price){
        this.discountName = badge;
        this.discountPrice = discount_Price;
    }

    public String getDiscountName(){
        return discountName;
    }
    public int getDiscountPrice(){
        return discountPrice;
    }
}
