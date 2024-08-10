package introduction.인덱스바꾸기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    @Test
    void 인덱스바꾸기() {
        Assertions.assertThat(solution("I love you", 3, 6))
                .isEqualTo("I l veoyou");
    }

    /*
        문제 : 인덱스 바꾸기
        https://school.programmers.co.kr/learn/courses/30/lessons/120895
        접근 방법 :
        my_string을 ""기준으로 자른 다음
        num1 과 num2 의 인덱스 위치 바꾸고 다시 joining 하기
        좋아요 많은 풀이 :
        String을 짤라 인덱스를 바꿔 합치는 접근 동일

     */
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        String temp = "";
        String[] split = my_string.split("");

        temp = split[num1];
        split[num1] = split[num2];
        split[num2] = temp;

        return Arrays.stream(split)
                .collect(Collectors.joining());
    }
}
