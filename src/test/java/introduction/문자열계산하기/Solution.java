package introduction.문자열계산하기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    @Test
    void 문자열_계산하기() {
        Assertions.assertThat(solution("3 + 4")).isEqualTo(7);
    }

    /*
        문제 : 문자열 계산하기
        https://school.programmers.co.kr/learn/courses/30/lessons/120902
        접근방법 :
        3 + 4 -2 ... 이런식으로 나열되어 있어서 처음 숫자를 제외하면
        공백 + 연산자 + 공백 + 숫자 의 반복이기 때문에
        첫번째 숫자는 공백전까지만 추출해서 뽑아내고
        나머지는 정규식으로 찾아내서 숫자로 바꿔서 계산 해낸다.

        좋아요 많은 풀이 :
        나는 정직한 규칙을 찾아서 분리해서 계산할 생각을 했었는데
        아이디어가 좋음 (음수도 더할 수 있다는 숫자의 성질을 잘 활용함)
        "- " 부분을 "-"로 다 바꾸고, +가 들어간 부분은 ""으로 변경처리하고 전부 더해버려서 계산해냈음.
        예를들어 "3 + 4 - 2" 의 경우 위 내용을 적용하면
        "3 4 -2"가 되고 이를 split(" ") 하면 3,4,-2 가 되니까 그냥 다 더해버리면 됨.
     */
    public int solution(String my_string) {
        int answer = Integer.parseInt(my_string.split("\\s+")[0]);
        Pattern compile = Pattern.compile("^\\d+\\s*");
        Pattern compile1 = Pattern.compile("[+-]\\s*\\d+");
        Matcher matcher = compile.matcher(my_string);

        String data = matcher.replaceFirst("");
        Matcher matcher1 = compile1.matcher(data);

        while(matcher1.find()) {
            String matched = matcher1.group().replaceFirst(" ","");
            if(matched.contains("+")) {
                answer += Integer.parseInt(matched.substring(1));
            }
            if(matched.contains("-")) {
                answer -= Integer.parseInt(matched.substring(1));
            }
        }

        return answer;
    }

}
