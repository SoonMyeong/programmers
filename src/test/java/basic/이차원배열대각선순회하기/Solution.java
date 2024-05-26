package basic.이차원배열대각선순회하기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 이차원_배열_대각선_순회하기() {
        Assertions.assertThat(solution(new int[][] {{0, 1, 2},{1, 2, 3},{2, 3, 4},{3, 4, 5}},2))
                .isEqualTo(8);
    }

    /*
        문제 : 이차원배열 대각선 순회하기
        https://school.programmers.co.kr/learn/courses/30/lessons/181829
        접근 방법 :
        board 를 순회하면서 행+열의 합이 k 보다 작거나 같은
        board[i][j] 의 합을 구하는 문제

        베스트풀이 확인 :
        거의 동일, 베스트풀이는 break 를 활용해 조금 더 순회 횟수 줄여볼라고 노력함
     */
    public int solution(int[][] board, int k) {
        int answer = 0;

        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[i].length; j++) {
                if(i+j <= k) {
                    answer += board[i][j];
                }
            }
        }

        return answer;
    }

}
