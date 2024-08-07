package basic.옷가게할인받기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 옷가게할인받기() {
        Assertions.assertThat(solution(580_000)).isEqualTo(464_000);
    }

    /*
        문제 : 옷가게 할인 받기
        https://school.programmers.co.kr/learn/courses/30/lessons/120818
        접근 방법 :
        소수점 이하 버린 정수라서 int type 쓰면 될거 같고
        10만원 이상 5% 할인
        30만원 이상 10% 할인
        50만원 이상 20% 할인
        조건 넣으면 끝
        좋아요 많은 풀이 :
        읭; 똑같음
     */
    public int solution(int price) {
        if(price >= 500_000) {
            return (int) (price * 0.8);
        }
        if(price >= 300_000) {
            return (int) (price * 0.9);
        }
        if(price >= 100_000) {
            return (int) (price * 0.95);
        }

        return price;
    }
}
