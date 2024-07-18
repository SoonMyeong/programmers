package introduction.가위바위보;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    @Test
    void 가위바위보() {
        Assertions.assertThat(solution("205")).isEqualTo("052");
    }

    /*
        문제 : 가위바위보
        https://school.programmers.co.kr/learn/courses/30/lessons/120839
        접근 방법 :
        문자열을"" 기준으로 잘라서 바위0,가위2, 보5 에 해당하는 숫자에 이길 수 있는
        숫자를 넣고 문자열을 만들어 리턴한다.

        베스트풀이 확인:
        거의 같음 좋아요 많은 풀이는 삼항연산자 이어서 해결
     */
    public String solution(String rsp) {
        String[] rspArray = rsp.split("");

        return Arrays.stream(rspArray)
                .map(m -> {
                    if("0".equals(m)) {
                        return "5";
                    }
                    if("2".equals(m)) {
                        return "0";
                    }
                    if("5".equals(m)) {
                        return "2";
                    }
                    return null;
                })
                .collect(Collectors.joining());
    }
}
