package basic.배열만들기1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    void 배열만들기1() {
        Assertions.assertThat(solution(10,3))
                .isEqualTo(new int[] {3,6,9});
    }

    /*
        문제 : 배열만들기 1
        https://school.programmers.co.kr/learn/courses/30/lessons/181901
        접근 방법 :
        1이상 n 이하 정수 중 k 배수 넣기
        for 문으로 해결 가능해 보임

        베스트풀이 확인 :
        거의 비슷함
     */
    public int[] solution(int n, int k) {
        List<Integer> answer = new ArrayList<>();
        for(int i = k; i<=n; i+=k) {
            answer.add(i);
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
