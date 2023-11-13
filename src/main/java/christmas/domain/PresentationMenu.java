package christmas.domain;

public class PresentationMenu {
    private final String presentation;
    private static final String ONE_CHAMPAGNE = "샴페인 1개";
    private static final String NOTHING = "없음";
    private static final int MINIMUM_DISCOUNT_PRICE_FOR_PRESENTATION = 120000;

    public PresentationMenu(int total_Discount){
        this.presentation = SelectPresentationByDiscountPrice(total_Discount);
    }
    public String getPresentation(){
        return presentation;
    }

    private String SelectPresentationByDiscountPrice(int total_Discount){
        if(total_Discount < MINIMUM_DISCOUNT_PRICE_FOR_PRESENTATION){
            return NOTHING;
        }
        return ONE_CHAMPAGNE;
    }
}
