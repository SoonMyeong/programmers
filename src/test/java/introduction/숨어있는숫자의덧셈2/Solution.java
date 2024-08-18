package introduction.숨어있는숫자의덧셈2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {
    @Test
    void 숨어있는_숫자의_덧셈2() {
        Assertions.assertThat(solution("aAb1B2cC34oOp")).isEqualTo(37);
    }

    /*
        문제 : 숨어있는 숫자의 덧셈2
        https://school.programmers.co.kr/learn/courses/30/lessons/120864
        접근 방법 :
        알파벳 사이에 있는 숫자들의 합을 구해야 함.
        split 자를때 정규표현식 가능하니까 알파벳 대소문자기준으로 짤라서
        숫자들 다 더하면 끝날듯

        좋아요 많은 풀이 :
        다들 정규표현식으로 품
     */
    public int solution(String my_string) {
        return Arrays.stream(my_string.split("[A-Za-z]"))
                .filter(s -> !"".equals(s))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
