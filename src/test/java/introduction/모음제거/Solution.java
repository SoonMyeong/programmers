package introduction.모음제거;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    @Test
    void 모음제거() {
        Assertions.assertThat(solution("bus")).isEqualTo("bs");
    }

    /*
        문제 : 모음 제거
        https://school.programmers.co.kr/learn/courses/30/lessons/120849
        접근 방법 :
        a e i o u 를 뺀 나머지 합쳐서 리턴

     */
    public String solution(String my_string) {
        return Arrays.stream(my_string.split(""))
                .filter(s -> !s.equals("a") && !s.equals("e") && !s.equals("i") && !s.equals("o") && !s.equals("u"))
                .collect(Collectors.joining());
    }
}
