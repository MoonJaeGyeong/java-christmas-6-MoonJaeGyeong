package christmas.domain.event;

public class PresentationMenu {
    private final String presentation;
    private static final String ONE_CHAMPAGNE = "샴페인 1개";
    private static final String NOTHING = "없음";
    private static final int MINIMUM_PRICE_PRICE_FOR_PRESENTATION = 120000;

    public PresentationMenu(int total_Price){
        this.presentation = SelectPresentationByTotalPrice(total_Price);
    }
    public String getPresentation(){
        return presentation;
    }

    public boolean isPresentation(){
        return !presentation.equals("없음");
    }

    private String SelectPresentationByTotalPrice(int total_Price){
        if(total_Price < MINIMUM_PRICE_PRICE_FOR_PRESENTATION){
            return NOTHING;
        }
        return ONE_CHAMPAGNE;
    }
}
