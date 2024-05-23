package basic.수열과구간쿼리1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {
    @Test
    void 수열과구간쿼리1() {
        Assertions.assertThat(solution(new int[] {0,1,2,3,4}, new int[][] {{0,1},{1,2},{2,3}}))
                .isEqualTo(new int[]{1,3,4,4,4});
    }

    /*
        문제 : 수열과 구간쿼리 1
        https://school.programmers.co.kr/learn/courses/30/lessons/181883

        접근방법 :
        쿼리 배열 안에 들어있는 인덱스 범위의 arr 원소 값에 +1 하면 됨

        베스트풀이 확인 :
        동일
     */
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = Arrays.copyOf(arr, arr.length);
        for(int[] query : queries ) {
            for(int i = query[0]; i<=query[1]; i++) {
                answer[i]++;
            }
        }
        return answer;
    }

}
