package basic.문자열뒤집기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 문자열뒤집기() {
        Assertions.assertThat(solution("Progra21Sremm3",6,12)).isEqualTo("ProgrammerS123");
        Assertions.assertThat(solution("Stanley1yelnatS",4,10)).isEqualTo("Stanley1yelnatS");
    }

    /*
        문제 : 문자열 뒤집기
        https://school.programmers.co.kr/learn/courses/30/lessons/181905

        접근 방법 :
        my_string 의 인덱스 s 부터 e 까지를 뒤집은 문자열을 구하라는건데
        인덱스 s 부터 e 까지 StringBuilder 에 넣고 reverse 해준다음에
        my_string 의 인덱스 0부터 s 전까지의 substring 이랑 reverse 값이랑 인덱스 e 이후의 substring 의 합
        구해주면 될 거 같음

        베스트풀이 확인 :
        베스트풀이와 거의 동일, 베스트풀이는 for문 내용까지 substring 으로 표현.
        다시 보니 베스트풀이 방식이 더 낫네. 나 왜 for문 돌렸지 -_-
     */
    public String solution(String my_string, int s, int e) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = s; i<=e; i++) {
            sb.append(my_string.charAt(i));
        }
        answer = my_string.substring(0, s) + sb.reverse() + my_string.substring(e + 1);

        return answer;
    }

}
