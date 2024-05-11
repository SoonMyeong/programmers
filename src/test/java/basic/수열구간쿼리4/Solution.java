package basic.수열구간쿼리4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 수열구간쿼리4() {
        Assertions.assertThat(solution(new int[]{0,1,2,4,3,}
                , new int[][]{{0, 4, 1},{0, 3, 2},{0, 3, 3}})).isEqualTo(new int[]{3,2,4,6,4});
    }

    /*
        문제 : 수열과 구간 쿼리4
        https://school.programmers.co.kr/learn/courses/30/lessons/181922

        접근방법 :
        이 문제 맘에 안듬
        '배수이면 ' 이라는 말을 하면서 0,1,2,3 중에서 3의 배수가 0,3 이라고 그러는데
        1의 배수, 2의 배수는 마지막 자리수에 0이 나올수 있으니까 0을 포함하는게 그러려니 했는데
        3의 배수는 3부터 시작아닌가? 하고 고민했던 문제
        검색해보니 0은 모든 정수의 배수라네..

        베스트풀이 확인 :
        대부분 비슷하게 품

     */
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] query : queries) {
            for(int i = query[0]; i<=query[1]; i++) {
                if(query[2] == 0 || i % query[2] == 0) {
                    arr[i]++;
                }
            }
        }
        return arr;
    }

}
