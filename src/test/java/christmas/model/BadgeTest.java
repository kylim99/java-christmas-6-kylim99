package christmas.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class BadgeTest {

    @Test
    void 배지_생성_테스트(){
        Badge badge1 = Arrays.stream(Badge.values())
                .filter(badge -> badge.apply(-20000))
                .findFirst()
                .orElseThrow();
        Badge badge2 = Arrays.stream(Badge.values())
                .filter(badge -> badge.apply(-10000))
                .findFirst()
                .orElseThrow();
        Badge badge3 = Arrays.stream(Badge.values())
                .filter(badge -> badge.apply(-5000))
                .findFirst()
                .orElseThrow();
        Badge badge4 = Arrays.stream(Badge.values())
                .filter(badge -> badge.apply(-2000))
                .findFirst()
                .orElseThrow();

        assertThat(badge1).isEqualTo(Badge.SANTA);
        assertThat(badge2).isEqualTo(Badge.TREE);
        assertThat(badge3).isEqualTo(Badge.STAR);
        assertThat(badge4).isEqualTo(Badge.NONE);
    }

}
