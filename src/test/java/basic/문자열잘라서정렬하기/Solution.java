package basic.문자열잘라서정렬하기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {
    @Test
    void 문자열잘라서정렬하기() {
        Assertions.assertThat(solution("axbxcxdx"))
                .isEqualTo(new String[] {"a","b","c","d"});
    }

    /*
        문제 : 문자열 잘라서 정렬하기
        https://school.programmers.co.kr/learn/courses/30/lessons/181866
        접근방법 : x로 자른뒤 사전순 정렬 해야 함
        베스트풀이 확인 : isEmpty() 쓴거 정도 차이 빼고 동일
     */
    public String[] solution(String myString) {
        return Arrays.stream(myString.split("x"))
                .sorted()
                .filter(str -> !str.equals(""))
                .toArray(String[]::new);
    }

}
