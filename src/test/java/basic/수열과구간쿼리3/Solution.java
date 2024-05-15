package basic.수열과구간쿼리3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 수열과_구간_쿼리3() {
        Assertions.assertThat(solution(new int[] {0,1,2,3,4}, new int[][] {{0,3},{1,2},{1,4}}))
                .isEqualTo(new int[] {3,4,1,0,2});
    }

    /*
        문제 : 수열과 구간 쿼리 3
        https://school.programmers.co.kr/learn/courses/30/lessons/181924

        문제 접근 :
        쿼리에 속하는 원소 2개 위치를 서로 바꿔주면 끝..

        베스트풀이 확인 :
        똑같음, 사실 실무 생각해보면 파라미터를 직접 건드려 값을 바꿔버리는건 좋지 않고
        베스트풀이처럼 copy 해놓고 작업해야 원본을 변경시키지 않으므로 더 좋음
        int[] answer = Arrays.copyOf(arr, arr.length);
     */
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] query : queries) {
            int temp = arr[query[0]];
            arr[query[0]] = arr[query[1]];
            arr[query[1]] = temp;
        }
        return arr;
    }

}
