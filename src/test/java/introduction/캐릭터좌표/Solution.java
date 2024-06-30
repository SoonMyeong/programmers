package introduction.캐릭터좌표;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 캐릭터의_좌표() {
        Assertions.assertThat(solution(new String[] {"left", "right", "up", "right", "right"}, new int[]{11,11}))
                .isEqualTo(new int[] {2,1});
        Assertions.assertThat(solution(new String[] {"down", "down", "down", "down", "down"}, new int[]{7,9}))
                .isEqualTo(new int[] {0,-4});
    }

    /*
        문제 : 캐릭터의 좌표
        https://school.programmers.co.kr/learn/courses/30/lessons/120861
        접근 방법 :
        시작점인 [0,0]이 정 중앙에 위치한다고 하면 결국 상하좌우 board 사이즈의 절반까지만 이동할 수 있음.
        이동 가능한지만 체크하면서 방향에 따라 좌표를 이동시키면 됨.
        left 와 right 는 행 범위를 체크하면 되고 up 과 down 은 열 범위를 체크하면 된다.

        좋아요 많은 풀이 :
        switch 나 for loop 으로 풀면 됨.
        정성껏 풀어낸 코드들이 제법 보이는데.. 뭐 연습이니까 그럴 수 있지.. 제대로 읽을 필요도 없어서 안읽음
        핵심은 좌표를 움직일 때 범위 체크를 하냐는거임

     */
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int leftRightRange = board[0] / 2;
        int upDownRange = board[1] / 2;

        for(String key : keyinput) {
            if("left".equals(key) && answer[0] -1 >= -leftRightRange) {
                answer[0]--;
            }
            if("right".equals(key) && answer[0] +1 <= leftRightRange) {
                answer[0]++;
            }
            if("up".equals(key) && answer[1] +1 <= upDownRange) {
                answer[1]++;
            }
            if("down".equals(key) && answer[1] -1 >= -upDownRange) {
                answer[1]--;
            }
        }
        return answer;
    }
}
