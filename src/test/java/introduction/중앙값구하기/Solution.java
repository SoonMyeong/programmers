package introduction.중앙값구하기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {
    @Test
    void 중앙값_구하기() {
        Assertions.assertThat(solution(new int[]{1,2,7,10,11})).isEqualTo(7);
    }

    /*
        문제 : 중앙값 구하기
        https://school.programmers.co.kr/learn/courses/30/lessons/120811
        접근 방법 :
        정렬 후 길이가 홀수인지 짝수인지에 따른 중앙 위치 원소 값 리턴 하기
        좋아요 많은 풀이 :
        비슷함, 시프트연산으로 풀긴했는데.. 가독성 별로;
     */
    public int solution(int[] array) {
        Arrays.sort(array);

        if(array.length % 2 == 0) {
            return array[array.length/2 -1];
        }else {
            return array[array.length/2];
        }
    }
}
