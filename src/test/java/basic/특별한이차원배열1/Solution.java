package basic.특별한이차원배열1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 특별한_이차원배열_1() {
        Assertions.assertThat(solution(3)).isEqualTo(new int[][]{{1,0,0},{0,1,0},{0,0,1}});
        Assertions.assertThat(solution(1)).isEqualTo(new int[][]{{1}});
    }

    /*
        문제 : 특별한 이차원배열 1
        https://school.programmers.co.kr/learn/courses/30/lessons/181833
        접근 방법 :
        i와 j가 같은 위치만 1로 채워주면 됨
        primitive type int default 가 0 이니까 1 인 값만 채워주면 됨

        베스트풀이 확인 :
        i==j 조건이니까 결국 행,열 둘다 i 값인 자리에 1 넣어도 동일하다는 접근방법으로
        for 문 한번에 해결함
        for(int i = 0; i < n; i++) {
            answer[i][i] = 1;
        }
     */
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        if(n == 1) {
            return new int[][] {{1}};
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i==j) {
                    answer[i][j] = 1;
                }
            }
        }
        return answer;
    }
}
