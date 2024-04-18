package basic.대소문자바꿔서출력하기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 대소문자바꿔서_출력하기() {
        Assertions.assertThat(solution("aBcDeFg")).isEqualTo("AbCdEfG");
        Assertions.assertThat(solution("aaaBBB")).isEqualTo("AAAbbb");
    }

    /*
     문제 : 대소문자바꿔서 출력하기
     https://school.programmers.co.kr/learn/courses/30/lessons/181949
     접근방법 >
        그냥 구현;
     베스트 답안 확인>
        동일
     */
    private String solution(String str) {
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()) {
            if(Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            }
            if(Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

}
