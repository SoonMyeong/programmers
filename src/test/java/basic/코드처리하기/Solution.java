package basic.코드처리하기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class Solution {
    @Test
    void 코드_처리하기() {
        Assertions.assertThat(solution("abc1abc1abc")).isEqualTo("acbac");
    }

    /*
    문제 : 코드 처리하기
    https://school.programmers.co.kr/learn/courses/30/lessons/181932

    접근방식>
    제한사항 확인 시 code 에 들어오는 문자는 알파벳 소문자 or "1" 임
    숫자인지 체크 해서 mode change 를 결정
    mode 0
    - code[idx] 가 "1" 아니면서 idx 짝수 일 때만 ret 맨 뒤 code[idx] 추가
    - code[idx] 가 "1" 이면 mode 변경
    mode 1
    - code[idx] 가 "1" 아니면서 idx 홀수 일 때만 ret 맨 뒤 code[idx] 추가
    - code[idx] 가 "1" 이면 mode 변경
    시작 mode 0, 빈 문자열 "EMPTY"

    베스트 답안 확인>
    if(i%2 == mode) answer.append(current);
    공통점을 센스있게 찾아냈음.
    위 조건대로라면 mode 가 1 일 때, i는 홀수 일때 append 하고
    mode 가 0 일 때, i는 짝수여야 append 하는데
    문제에 존재하는 mode 는 짝수와 홀수 인걸 캐치해서 적용한 센스가 돋보임
     */
    public String solution(String code) {
        StringBuilder answer = new StringBuilder();
        char[] chars = code.toCharArray();
        int mode = 0;

        for(int i = 0; i<chars.length; i++) {
            if(mode == 0) {
                if(i%2 == 0 && !Character.isDigit(chars[i])) {
                    answer.append(chars[i]);
                }
                if(Character.isDigit(chars[i])) {
                    mode = 1;
                }
                continue;
            }
            if(i%2 != 0 && !Character.isDigit(chars[i])) {
                answer.append(chars[i]);
            }
            if(Character.isDigit(chars[i])) {
                mode = 0;
            }
        }

        if(answer.isEmpty()) {
            answer.append("EMPTY");
        }

        return answer.toString();
    }
}
