package introduction.머쓱이보다키큰사람;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {
    @Test
    void 머쓱이보다키큰사람() {
        Assertions.assertThat(solution(new int[] {149,180,192,170}, 167)).isEqualTo(3);
    }

    /*
        문제 : 머쓱이보다 키 큰 사람
        https://school.programmers.co.kr/learn/courses/30/lessons/120585
        접근 방법 :
        배열에서 height 보다 큰 값을 카운팅
     */
    public int solution(int[] array, int height) {
        return (int) Arrays.stream(array)
                .filter(i -> i > height)
                .count();
    }
}
