package introduction.편지;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 편지() {
        Assertions.assertThat(solution("happy birthday!")).isEqualTo(30);
    }

    /*
        문제 : 편지
        https://school.programmers.co.kr/learn/courses/30/lessons/120898
        접근 방법 : 글자 크기가 2cm 로 적는다니까 문자열길이 x2 해주면 됨
        좋아요 많은 풀이 : 동일
     */
    public int solution(String message) {
        return message.length() * 2;
    }
}
