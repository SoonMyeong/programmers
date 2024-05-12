package basic.문자열몇번등장하는지세기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class Solution {
    @Test
    void 문자열_몇번_등장하는지_세기() {
        Assertions.assertThat(solution("banana","ana")).isEqualTo(2);
        Assertions.assertThat(solution("aaaa","aa")).isEqualTo(3);
        Assertions.assertThat(solution("nanana","nana")).isEqualTo(2);
    }

    /*
        문제 : 문자열이 몇번 등장하는지 세기
        https://school.programmers.co.kr/learn/courses/30/lessons/181871

        문제 접근 :
        pat 문자열의 첫번째 문자를 포함하는 인덱스 위치를 myString 에서 찾아서
        그 인덱스 위치부터 pat 문자열 길이만큼 짤라서 비교해보고 포함하면 개수 증가 하는 방법으로 해봄

        베스트풀이 확인 :
        아맞다... startWith 메서드 있었지 참 -_- ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ

     */
    public int solution(String myString, String pat) {
        int answer = 0;
        char[] split = myString.toCharArray();
        for(int i = 0; i<=split.length - pat.length(); i++) {
            if(pat.charAt(0) == split[i]) {
                StringBuilder tmp = new StringBuilder();
                for(int j = i; j < i + pat.length(); j++) {
                    tmp.append(split[j]);
                }
                if(pat.equals(tmp.toString())) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
