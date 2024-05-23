package basic.특정문자열로끝나는가장긴부분문자열찾기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 특정문자열로끝나는가장긴부분문자열찾기() {
        Assertions.assertThat(solution("AbCdEFG", "dE")).isEqualTo("AbCdE");
        Assertions.assertThat(solution("AAAAaaaa", "a")).isEqualTo("AAAAaaaa");
    }

    /*
        문제 : 특정문자열로끝나는가장긴부분문자열찾기
        https://school.programmers.co.kr/learn/courses/30/lessons/181872
        접근 방법 :
        다행히 부분문자 위치는 고정되어 있기 때문에
        String 을 부분부분 합쳐가며 pat 으로 끝나는 가장 긴 문자열을 찾아내면 될 거같음

        베스트풀이 확인:
        읭?? lastIndexOf 라는 메서드에 합쳐진 문자열도 가능했구나 굳
        int idx = myString.lastIndexOf(pat);
        answer = myString.substring(0, idx) + pat;
     */
    public String solution(String myString, String pat) {
        String answer = "";
        String temp = "";
        for(int i = 0; i<myString.length(); i++) {
            temp += myString.charAt(i);
            if(temp.length() >= pat.length()
                    && pat.equals(temp.substring(temp.length() - pat.length()))) {
                answer += temp;
                temp = "";
            }
        }
        return answer;
    }
}
