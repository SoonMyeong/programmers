package basic.정사각형으로만들기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 정사각형으로_만들기() {
        Assertions.assertThat(solution(new int[][]{{572, 22, 37}, {287, 726, 384}, {85, 137, 292}, {487, 13, 876}}))
                .isEqualTo(new int[][]{{572, 22, 37, 0}, {287, 726, 384, 0}, {85, 137, 292, 0}, {487, 13, 876, 0}});
    }
    /*
        문제 : 정사각형으로 만들기
        https://school.programmers.co.kr/learn/courses/30/lessons/181830

        접근방법>
        2차원배열의 행길이와 열길이를 체크한 다음, 더 큰쪽의 사이즈로 새로운 2차원배열을 만들고
        거기다가 기존 2차원배열 값 넣고, 남은 공간은 그냥 두면 됨. 기본 다 0 셋팅이니까

        베스트풀이 확인>
        똑같네
     */
    public int[][] solution(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int size = Math.max(row, col);
        int[][] answer = new int[size][size];

        for(int i = 0; i<row; i++) {
            System.arraycopy(arr[i], 0, answer[i], 0, col);
        }

        return answer;
    }

}
