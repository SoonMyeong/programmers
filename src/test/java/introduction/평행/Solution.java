package introduction.평행;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 평행() {
        Assertions.assertThat(solution(new int[][]{{1, 4}, {9, 2}, {3, 8}, {11, 6}})).isEqualTo(1);
        Assertions.assertThat(solution(new int[][]{{3, 5}, {4, 1}, {2, 4}, {5, 10}})).isEqualTo(0);
    }

    /*
        문제 : 평행
        https://school.programmers.co.kr/learn/courses/30/lessons/120875
        접근 방법 :
        두 직선이 평행이 되는 경우는 두 직선의 기울기가 같으면 된다.
        (기울기 : x증가량 / y증가량)
        평행이 되기 위해서는 한점에서 두개의 직선이 나오면 안된다.
        이를 염두해 둘 경우 체크할 수 있는 경우의 수는 3가지가 된다.

        [x1, y1], [x2, y2], [x3, y3], [x4, y4] 라고 한다면

        [x1, y1], [x2, y2] | [x3, y3], [x4, y4] -- case 1
        [x1, y1], [x3, y3] | [x2, y2],  [x4, y4] -- case 2
        [x1, y1], [x4, y4] | [x2, y2], [x3, y3] -- case 3

        3가지 케이스 중 하나라도 두 기울기가 같은게 있다면 평행을 만들 수 있다는 의미가 된다.

        좋아요 많은 풀이 :
        다들 좀 복잡하게 푸는 느낌이 강하긴한데 비슷한 케이스도 있음
     */
    public int solution(int[][] dots) {
        return isParallelLine(dots,0,1,2,3)
                || isParallelLine(dots,0,2,1,3)
                || isParallelLine(dots,0,3,1,2) ? 1 : 0;
    }

    public boolean isParallelLine(int[][]dots, int x1, int x2, int x3, int x4) {
        double xx = Math.abs(dots[x1][0] - dots[x2][0]);
        double yy = Math.abs(dots[x1][1] - dots[x2][1]);
        double xxx = Math.abs(dots[x3][0] - dots[x4][0]);
        double yyy = Math.abs(dots[x3][1] - dots[x4][1]);

        double m1 =  yy/xx;
        double m2 =  yyy/xxx;

        return m1 == m2;
    }



}
