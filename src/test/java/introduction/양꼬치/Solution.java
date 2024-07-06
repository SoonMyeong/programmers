package introduction.양꼬치;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 양꼬치() {
        Assertions.assertThat(solution(10,3)).isEqualTo(124_000);
        Assertions.assertThat(solution(64,6)).isEqualTo(768_000);
    }

    /*
        문제 : 양꼬치
        https://school.programmers.co.kr/learn/courses/30/lessons/120830
        접근 방법 :
        양꼬치 10개당 음료 하나 서비스 이므로 이를 생각하며 풀면 될듯
        양꼬치를 산 개수 / 10 만큼 음료 보너스를 받음 이를 마이너스 해줘야 함

        좋아요 많은 풀이 :
        광기의 코딩이 좋아요 가장많음, 그 외 같음
     */
    public int solution(int n, int k) {
        int service = n/10;

        return (n * 12_000) + (k * 2_000) - (service * 2000);
    }
}
