package introduction.저주의숫자3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 저주의숫자3() {
        Assertions.assertThat(solution(15)).isEqualTo(25);
        Assertions.assertThat(solution(40)).isEqualTo(76);
    }

    /*
        문제 : 저주의 숫자 3
        https://school.programmers.co.kr/learn/courses/30/lessons/120871
        접근 방법 :
        1부터 n까지 반복하면서 answer 값이 3의 배수나 3을 포함하면 answer 를 늘려주는 방법으로 접근하면
        해결 될거 같음
        베스트풀이 확인 :
        접근방향동일, 풀이의 경우 while 없이 answer 를 -하는 방법으로 품
        결국 구현방법의 차이, 방향성은 동일
     */
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i<=n; i++) {
            answer++;
            while(answer%3 == 0 || String.valueOf(answer).contains("3")) {
                answer++;
            }
        }
        return answer;
    }
}
