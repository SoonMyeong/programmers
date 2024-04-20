package basic.문자열겹쳐쓰기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 문자열겹쳐쓰기() {
        Assertions.assertThat(solution("He11oWor1d", "lloWorl", 2)).isEqualTo("HelloWorld");
        Assertions.assertThat(solution("Program29b8UYP", "merS123", 7)).isEqualTo("ProgrammerS123");
    }

    /*
        문제 : 문자열 겹쳐쓰기
        https://school.programmers.co.kr/learn/courses/30/lessons/181943

        접근방법>
        (my_sring 길이 - 인덱스 s) - overwrite_string 값 확인 -> 1번
        인덱스 s 전까지 my_string 에서 넣고
         overwrite_string 길이만큼 overwrite_string 넣고
        만약 1번의 값이 양수면 (인덱스 s + overwrite_string 길이) 인덱스부터 my_string 문자로 채움
        나머지는 마무리.

        베스트풀이 확인>
        큰 맥락은 동일한데 나는 루프돌렸고 숏코드는 substring 으로 자름
        substring 쓰니까 나처럼 temp 체크할 필요가 없어서 깔끔함
        my_string.substring(0, s) + overwrite_string + my_string.substring(s + overwrite_string.length());

     */
    public String solution(String my_string, String overwrite_string, int s) {
        StringBuilder answer = new StringBuilder();
        int temp = (my_string.length() - s) - overwrite_string.length();

        for(int i = 0; i < s; i++) {
            answer.append(my_string.charAt(i));
        }
        for(int i = 0; i<overwrite_string.length(); i++) {
            answer.append(overwrite_string.charAt(i));
        }

        if(temp > 0) {
            for(int i = (s + overwrite_string.length()); i<my_string.length(); i++) {
                answer.append(my_string.charAt(i));
            }
        }

        return answer.toString();
    }
}
