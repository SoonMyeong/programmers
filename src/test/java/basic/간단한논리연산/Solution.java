package basic.간단한논리연산;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 간단한_논리_연산() {
        Assertions.assertThat(solution(false,true,true,true)).isTrue();
        Assertions.assertThat(solution(true,false,false,false)).isFalse();
    }

    /*
        문제 : 간단한 논리 연산
        https://school.programmers.co.kr/learn/courses/30/lessons/181917

        문제 접근 :
        어 그냥 논리연산?
        베스트풀이 확인 : 맞음
     */
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean answer = true;
        return (x1||x2) && (x3||x4);
    }

}
