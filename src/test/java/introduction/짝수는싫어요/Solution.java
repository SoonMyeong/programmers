package introduction.짝수는싫어요;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    void 짝수는싫어요() {
        Assertions.assertThat(solution(10))
                .isEqualTo(new int[] {1,2,3,5,7,9});
    }

    /*
        문제 : 짝수는 싫어요
        https://school.programmers.co.kr/learn/courses/30/lessons/120813
        접근 방법 :
        홀수만 오름차순 해서 담기
        좋아요 많은 풀이 :
        IntStream.rangeClosed 써서 한방에 스트림 풀이
        혹은 나처럼 풀이

     */
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i<=n; i+=2) {
            list.add(i);
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
