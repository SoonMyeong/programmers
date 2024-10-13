package introduction.OX퀴즈;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void ox퀴즈() {
        Assertions.assertThat(solution(new String[]{"3 - 4 = -3", "5 + 6 = 11"})).isEqualTo(new String[] {"X","O"});
        Assertions.assertThat(solution(new String[]{"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"}))
                .isEqualTo(new String[] {"O","O","X","O"});
    }

    @Test
    void test() {
        isPalindrome("a");
    }
    boolean isPalindrome(String s) {
        final var str = s.toLowerCase().replaceAll("[^a-z]","");
        if(str.length() < 1) {
            return true;
        }
        final var split = str.split("");

        if(split.length == 0) {
            return false;
        }

        var start = 0;
        var end = split.length -1;

        while(start <= end) {
            if(!split[start].equals(split[end])) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    /*
        문제 : OX 퀴즈
        https://school.programmers.co.kr/learn/courses/30/lessons/120907
        접근방법 :
        숫자와 오퍼레이터로 나눠낸뒤 작업하는게 중요하다.
        "3 - 4 = -3" 을 공백 기준으로 나눠보면
        splitData = ["3", "-", "4", "=", "-3"] 으로 나눠진다.
        이는 고정되기 때문에 splitData[1] 로 오퍼레이터를 찾아내고
        splitData[0] 과 splitData[2] 를 오퍼레이터 연산 한 결과가 splitData[4] 인지
        확인해 주면 될듯

        좋아요 많은 풀이:
        코드 라인수의 차이가 있을뿐 거의 다 비슷함
     */
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int i = 0;
        for(String q : quiz) {
            String[] splitData = q.split(" ");
            if(splitData[1].equals("+")) {
                answer[i] = Integer.parseInt(splitData[0])
                        + Integer.parseInt(splitData[2]) == Integer.parseInt(splitData[4]) ? "O" : "X";
            }
            if(splitData[1].equals("-")) {
                answer[i] = Integer.parseInt(splitData[0])
                        - Integer.parseInt(splitData[2]) == Integer.parseInt(splitData[4]) ? "O" : "X";
            }

            i++;
        }

        return answer;
    }
}
