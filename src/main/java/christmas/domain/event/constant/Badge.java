package christmas.domain.event.constant;

public enum Badge {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000),
    NOTHING("없음", 0);

    private final String badge;
    private final int discount_Price;

    Badge(String badge, int discount_Price){
        this.badge = badge;
        this.discount_Price = discount_Price;
    }

    public String getBadge(){
        return badge;
    }
    public int getDiscount_Price(){
        return discount_Price;
    }
}
