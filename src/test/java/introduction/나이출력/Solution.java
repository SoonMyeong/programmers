package introduction.나이출력;

import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 나이출력() {

    }

    /*
        문제 : 나이출력
        https://school.programmers.co.kr/learn/courses/30/lessons/120820
        접근 방법 :
        2022년 기준으로 계산해야 한다.
        그냥 뺴고 +1 해도 될 거같은데..
        좋아요 많은 풀이 :
        LocalDate 로 푼게 가장 좋아요가 많긴한데, 문제 조건이 2022년 기준이라서
        그대로 복붙하면 틀림.
     */
    public int solution(int age) {
        return 2022 - age + 1;
    }
}
