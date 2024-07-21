package introduction.팩토리얼;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 팩토리얼() {
        Assertions.assertThat(solution(3628800)).isEqualTo(10);
    }

    /*
        문제 : 팩토리얼
        https://school.programmers.co.kr/learn/courses/30/lessons/120848
        접근방법 :
        1팩토리얼 부터 하나 씩 늘려가면서 n값이 x팩토리얼 보다 커지면 x-1 값 리턴

        좋아요 많은 풀이 :
        재귀로 풀진 않고 곱해가는 식으로 구함
        나처럼 푼사람도 있긴함
     */
    public int solution(int n) {
        int answer = 0;
        int x = 1;
        while(true) {
            if(n < factorial(x)) {
                answer = x -1;
                break;
            }
            x++;
        }
        return answer;
    }

    private int factorial(int n) {
        if(n == 1) {
            return 1;
        }
        return n * factorial(n-1);
    }

}
