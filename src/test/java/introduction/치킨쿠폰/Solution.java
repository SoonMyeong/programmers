package introduction.치킨쿠폰;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 치킨쿠폰() {
        Assertions.assertThat(solution(1081)).isEqualTo(120);
        Assertions.assertThat(solution(1999)).isEqualTo(222);
    }

    /*
        문제 : 치킨쿠폰
        https://school.programmers.co.kr/learn/courses/30/lessons/120884
        접근 방법 :
        치킨 한마리 당 쿠폰 한장!
        쿠폰 10장 당 치킨 한마리 서비스!
        근데 서비스 치킨도 쿠폰을 줌! 개이득! 최대 받을 수 있는 서비스 치킨의 수를 구하는 문제
        치킨 개수만큼 쿠폰을 맞춰놓고
        쿠폰이 다 떨어질 때 까지 치킨주문을 하면서 그 치킨을 더해주면 됨
        치킨 주문 후 남아 있는 쿠폰 = (치킨주문 개수) + 쿠폰 % 10
        다른사람풀이 :
        거의 흡사함
     */
    public int solution(int chicken) {
        int remainCoupon = chicken;
        int answer = 0;
        while(remainCoupon >= 10) {
            int serviceChicken = remainCoupon / 10;
            answer += serviceChicken;
            remainCoupon = remainCoupon / 10 + remainCoupon % 10;
        }

        return answer;
    }
}
