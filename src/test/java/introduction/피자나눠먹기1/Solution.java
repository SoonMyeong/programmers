package introduction.피자나눠먹기1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 피자나눠먹기1() {
        Assertions.assertThat(solution(15)).isEqualTo(3);
    }

    /*
        문제 : 피자나눠먹기 1
        https://school.programmers.co.kr/learn/courses/30/lessons/120814
        접근방법 :
        피자는 7조각으로 잘라준다고 하니
        n을 7로 나누고 나머지가 있으면 +1 해주면 될듯

        좋아요많은 풀이:
        수학적 풀이로 접근
     */
    static final int PIZZA_SLICE_COUNT = 7;
    public int solution(int n) {
        int answer = 0;
        answer = n / PIZZA_SLICE_COUNT;
        if(n % PIZZA_SLICE_COUNT != 0) {
            answer++;
        }
        return answer;
    }
}
