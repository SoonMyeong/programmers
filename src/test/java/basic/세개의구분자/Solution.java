package basic.세개의구분자;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    void 세_개의_구분자() {
        Assertions.assertThat(solution("baconlettucetomato"))
                .isEqualTo(new String[] {"onlettu", "etom", "to"});
        Assertions.assertThat(solution("abcd"))
                .isEqualTo(new String[] {"d"});
        Assertions.assertThat(solution("cabab"))
                .isEqualTo(new String[] {"EMPTY"});
    }

    /*
       문제 : 세 개의 구분자
       https://school.programmers.co.kr/learn/courses/30/lessons/181862

       접근 방법 :
       문자 하나하나 charAt 으로 짤라서 a or b or c 중 하나면 지우고
       처음 a,b,c가 아니면 다음 a,b,c 가 나오기 전까지 합쳐서 추가하면 될거 같음

       베스트풀이 확인 :
       나처럼 푼사람도 있고 (문제 그대로 구현), 정규식 써서 쉽게 푼 사람들도 있었음.
       정규식 나온김에 정리
       [] : 괄호 안에 있는 것들 중 한 개이상 일치되는 것만
       + : 앞의 문자가 최소 한개 이상
       myStr.split("[abc]+") 이렇게 하게 될 경우 a 혹은 b 혹은 c가 하나라도 속하는 기준으로 자른다는 말임
       결국 a,b,c가 포함되지 않는 문자로 정렬 될 거고 그 중에서 공백이 아닌것만 골라내게끔 풀어냄.
     */
    public String[] solution(String myStr) {
        List<String> answer = new ArrayList<>();
        char[] chars = myStr.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : chars) {
            if(c == 'a' || c == 'b' || c == 'c' ) {
                if(sb.length() > 0) {
                    answer.add(sb.toString());
                }
                sb.setLength(0);
                continue;
            }
            sb.append(c);
        }
        if(sb.length() > 0) {
            answer.add(sb.toString());
        }

        if(answer.isEmpty()) {
            return new String[] {"EMPTY"};
        }

        return answer.toArray(new String[0]);
    }

}
