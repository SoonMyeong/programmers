package basic.qrcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void qr_code() {
        Assertions.assertThat(solution(3,1,"qjnwezgrpirldywt"))
                .isEqualTo("jerry");
        Assertions.assertThat(solution(1,0,"programmers"))
                .isEqualTo("programmers");
    }

    /*
        문제 : qr code
        https://school.programmers.co.kr/learn/courses/30/lessons/181903

        접근방법:
        입력받는 몫(q) 으로 각 인덱스를 나눈 나머지가
        입력받은 나머지(r) 과 동일한 인덱스들만 모아서 문자열 출력 하면 됨

        베스트풀이 확인:
        가장 많은 사람들의 풀이와 동일함
     */
    public String solution(int q, int r, String code) {
        String answer = "";
        char[] codeArray = code.toCharArray();
        for(int i = 0; i<codeArray.length; i++) {
            if(i % q == r) {
                answer += codeArray[i];
            }
        }

        return answer;
    }

}
