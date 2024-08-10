package introduction.피자나눠먹기2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 피자나눠먹기2() {
        Assertions.assertThat(solution(10)).isEqualTo(5);
    }

    /*
        문제 : 피자나눠먹기 2
        https://school.programmers.co.kr/learn/courses/30/lessons/120815
        접근 방법 :
        이번엔 피자를 6조각으로 잘라준다고 함
        6x 가 n의 배수가 되는 최소 값을 찾아주면 될듯
        사람수(n)의 범위가 최대 100까지니까 6x 가 100배수의 최소값은 600이므로
        100까지만 순회하면 됨

        좋아요많은풀이 :
        범위를 while(true)로 잡은거 빼면 나랑 같음
     */
    static final int PIZZA_SLICE_COUNT = 6;
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i<= 100; i++) {
            answer = i;
            if((PIZZA_SLICE_COUNT * answer) % n == 0) {
                break;
            }
        }
        return answer;
    }
}
