package introduction.각도기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 각도기() {
        Assertions.assertThat(solution(180)).isEqualTo(4);
    }

    /*
        문제 : 각도기
        https://school.programmers.co.kr/learn/courses/30/lessons/120829

        접근 방법 :
        예각 90도 미만  = 1
        직각 90도 = 2
        둔각 90 ~ 180 = 3
        평각 180 = 4
        에 맞게 if문 작성

        좋아요 많은 풀이:
        삼항연산자.. 아니면 if-else if
        if-else if 방식이 나쁜건 아닌데
        조건을 잘 파악하면 보통 if 만 써도 해결 됨
     */
    public int solution(int angle) {
        if(angle == 180) {
            return 4;
        }
        if(angle > 90) {
            return 3;
        }
        if(angle == 90) {
            return 2;
        }
        return 1;
    }
}
