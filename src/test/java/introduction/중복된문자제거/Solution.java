package introduction.중복된문자제거;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;


public class Solution {
    @Test
    void 중복된문자제거() {
        Assertions.assertThat(solution("people")).isEqualTo("peol");
    }

    /*
        문제 : 중복된 문자 제거
        https://school.programmers.co.kr/learn/courses/30/lessons/120888
        접근 방법 :
        my_string 을 순회하면서 포함안하면 추가, 포함하면 추가안하는 방법으로 해야
        순서 그대로 출력할 수 있음
        아니면 stream 써서 중복 제거하고.. joining 으로 모으기

        좋아요 많은 풀이 :
        생각한 접근방법과 동일하게 품
     */
    public String solution(String my_string) {
        return Arrays.stream(my_string.split(""))
                .distinct()
                .collect(Collectors.joining());
    }
}
