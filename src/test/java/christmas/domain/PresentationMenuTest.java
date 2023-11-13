package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;

class PresentationMenuTest {

    @Test
    void 기준가격_미만일때() {
        PresentationMenu presentationMenu = new PresentationMenu(100000);
        String presentation = presentationMenu.getPresentation();
        assertThat(presentation).isEqualTo("없음");
    }

    @Test
    void 기준가격_이상일때() {
        PresentationMenu presentationMenu = new PresentationMenu(130000);
        String presentation = presentationMenu.getPresentation();
        assertThat(presentation).isEqualTo("샴페인 1개");
    }
}
