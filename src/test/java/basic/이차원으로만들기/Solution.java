package basic.이차원으로만들기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 이차원으로_만들기() {
        Assertions.assertThat(solution(new int[]{1,2,3,4,5,6,7,8}, 2))
                .isEqualTo(new int[][]{{1,2},{3,4},{5,6},{7,8}});
    }

    /*
        문제 : 2차원으로 만들기
        https://school.programmers.co.kr/learn/courses/30/lessons/120842
        접근 방법 :

        좋아요 많은 풀이 :
        똑같은 풀이 있음, 베스트는 행을 (i/n) 열 (i%n) 으로 해서 포문 하나로 했다는 거
        예를들어 n 이 2 이고 num_list 길이가 10 이라고 하면
        num_list 를 순회하는데 i 값이 n의 배수가 되면 행을 바꾸게 됨, 동시에 열은 0으로 되고..
        그리고 다음 i 값이 n 배수 되기전까지는 유지하고 열만 늘어남
        아이디어가 좋음
     */
    public int[][] solution(int[] num_list, int n) {
        int len = num_list.length / n;
        int k = 0;
        int[][] answer = new int[len][n];
        for(int i = 0; i< len; i++) {
            for(int j = 0; j < n; j++) {
                answer[i][j] = num_list[k++];
            }
        }
        return answer;
    }
}
