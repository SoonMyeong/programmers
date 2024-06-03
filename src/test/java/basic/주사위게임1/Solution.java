package basic.주사위게임1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 주사위게임1() {
        Assertions.assertThat(solution(3,5)).isEqualTo(34);
        Assertions.assertThat(solution(6,1)).isEqualTo(14);
        Assertions.assertThat(solution(2,4)).isEqualTo(2);
    }

    /*
        문제 : 주사위게임 1
        https://school.programmers.co.kr/learn/courses/30/lessons/181839
        접근방법 :
        문제 그대로 구현
        좋아요 많은 풀이 :
        같음
     */
    public int solution(int a, int b) {
        if(a%2 !=0 && b%2 !=0) {
            return (int) (Math.pow(a,2) + Math.pow(b,2));
        }
        if(a%2 !=0 || b%2 !=0) {
            return 2 * (a+b);
        }
        return Math.abs(a-b);
    }
}
