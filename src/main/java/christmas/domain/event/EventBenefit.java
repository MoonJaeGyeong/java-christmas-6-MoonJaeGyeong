package christmas.domain.event;

import static christmas.domain.event.constant.Discount.PRESENTATION_MENU_DISCOUNT;

import christmas.domain.Order;
import christmas.domain.VisitDay;
import java.util.HashMap;
import java.util.Map;
import org.mockito.internal.matchers.Or;

public class EventBenefit{
    private final Map<String, Integer> benefitInfo;
    private final EventDiscount eventDiscount;
    private final EventBadge eventBadge;
    private final PresentationMenu presentationMenu;

    public EventBenefit(VisitDay visitDay, Order order){
        this.eventDiscount = new EventDiscount(visitDay, order);
        this.benefitInfo = new HashMap<String, Integer>(eventDiscount.getDiscountInfo());
        this.presentationMenu = new PresentationMenu(order.TotalPrice());
        PresentationMenu();
        this.eventBadge = new EventBadge(getTotalBenefitPrice());

    }

    public int getTotalBenefitPrice(){
        return benefitInfo.values().stream()
                .mapToInt(Integer::intValue).sum();
    }

    public int getTotalDiscountPrice(){
        return eventDiscount.getTotalDiscountPrice();
    }

    public Map<String, Integer> getBenefitInfo(){
        return benefitInfo;
    }

    public String getBadge(){
        return eventBadge.getBadge();
    }

    public String getPresentation(){
        return presentationMenu.getPresentation();
    }

    private void PresentationMenu(){
        if(presentationMenu.isPresentation()){
            benefitInfo.put(PRESENTATION_MENU_DISCOUNT.getDiscountName(), PRESENTATION_MENU_DISCOUNT.getDiscountPrice());
        }
    }
}
