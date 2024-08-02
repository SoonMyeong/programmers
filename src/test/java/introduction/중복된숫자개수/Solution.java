package introduction.중복된숫자개수;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {
    @Test
    void 중복된숫자개수() {
        Assertions.assertThat(solution(new int[]{1,1,2,3,4,5}, 1)).isEqualTo(2);
    }

    /*
        문제 : 중복된 숫자 개수
        https://school.programmers.co.kr/learn/courses/30/lessons/120583
        접근 방법 :
        n을 찾으면 됨
        좋아요 많은 풀이 :
        그냥 for loop, stream 쓰는 풀이도 있음
        댓글들 보면 스트림을 싫어하는거같은데 이런상황에서 스트림이 좋은건데..ㅠ
     */
    public int solution(int[] array, int n) {
        return (int) Arrays.stream(array)
                .filter(i -> i == n)
                .count();
    }
}
