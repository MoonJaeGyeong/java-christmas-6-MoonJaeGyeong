package christmas.domain;


import christmas.domain.event.EventDiscount;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.mockito.internal.matchers.Or;

public class EventDiscountTest {

    @Test
    void 올바른_할인_금액_테스트(){
        VisitDay visitDay = new VisitDay("8");
        Order order = new Order("티본스테이크-2,아이스크림-1,초코케이크-2");
        EventDiscount eventDiscount = new EventDiscount(visitDay, order);
        assertThat(eventDiscount.getTotalDiscountPrice()).isEqualTo(-5746);
    }

}
