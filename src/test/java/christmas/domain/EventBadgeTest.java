package christmas.domain;

import christmas.domain.event.EventBadge;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class EventBadgeTest {

    @Test
    void 올바른_없음_이벤트_뱃지_생성_테스트(){
        EventBadge eventBadge = new EventBadge(2000);
        assertThat(eventBadge.getBadge()).isEqualTo("없음");
    }

    @Test
    void 올바른_별_이벤트_뱃지_생성_테스트(){
        EventBadge eventBadge = new EventBadge(5000);
        assertThat(eventBadge.getBadge()).isEqualTo("별");
    }

    @Test
    void 올바른_트리_이벤트_뱃지_생성_테스트(){
        EventBadge eventBadge = new EventBadge(10000);
        assertThat(eventBadge.getBadge()).isEqualTo("트리");
    }

    @Test
    void 올바른_산타_이벤트_뱃지_생성_테스트(){
        EventBadge eventBadge = new EventBadge(20000);
        assertThat(eventBadge.getBadge()).isEqualTo("산타");
    }
}
