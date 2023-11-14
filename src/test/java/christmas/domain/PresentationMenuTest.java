package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;


import christmas.domain.event.PresentationMenu;
import org.junit.jupiter.api.Test;

class PresentationMenuTest {
    private final static int MINIMUM_PRICE_PRICE_FOR_PRESENTATION = 120000;
    @Test
    void 기준가격_미만일때() {
        PresentationMenu presentationMenu = new PresentationMenu(MINIMUM_PRICE_PRICE_FOR_PRESENTATION - 1);
        String presentation = presentationMenu.getPresentation();
        assertThat(presentation).isEqualTo("없음");
    }

    @Test
    void 기준가격_이상일때() {
        PresentationMenu presentationMenu = new PresentationMenu(MINIMUM_PRICE_PRICE_FOR_PRESENTATION);
        String presentation = presentationMenu.getPresentation();
        assertThat(presentation).isEqualTo("샴페인 1개");
    }
}
