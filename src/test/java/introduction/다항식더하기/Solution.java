package introduction.다항식더하기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    @Test
    void 다항식더하기() {
        Assertions.assertThat(solution("3x + 7 + x")).isEqualTo("4x + 7");
        Assertions.assertThat(solution("x + x + x")).isEqualTo("3x");
        Assertions.assertThat(solution("x + 4 + 4")).isEqualTo("x + 8");
        Assertions.assertThat(solution("3 + 4 + 1")).isEqualTo("8");
        Assertions.assertThat(solution("10x + 20x")).isEqualTo("30x");
    }

    /*
        문제 : 다항식 더하기
        https://school.programmers.co.kr/learn/courses/30/lessons/120863
        접근 방법 :
        다행히 y 나 x^2 같은 항은 없고 x 밖에 없음
        ex) 3x + 7 + x
        1. 문자열을 " + " 를 기준으로 자른다. -> ["3x", "7", "x"]
        2. x 를 포함하는 문자열과 아닌 문자열을 나눈다. -> [isContains=["3x", "x"] , isNotContains=["7"]]
        3. x를 포함하는 문자열의 숫자들의 합을 구한다. 단 문자열의 길이가 1이면 값은 1로 처리한다. -> int xValue = 3+1
            - x는 가장 마지막에 붙기 때문에 substring 으로 구해내야 2자리수 이상도 계산할 수 있음
        4. x를 포함하지 않는 문자열 숫자들의 합을 구한다. -> int numValue = 7
        5. xValue + "x" + " + " + numValue 로 리턴한다.
        그러나 numValue 가 0 이면 추가 안함, xValue 가 1 보다 작거나 같으면 xValue 추가 안함

        좋아요 많은 풀이 :
        아.... 읽기힘들다 ㅠ 어쨋든 x 포함하면 x 를 빈값으로 replace 해주고 카운팅하고
        나머지 숫자들 카운팅한다음.. 삼항연산자 남발해서 처리하네.. 내 풀이보다 빠르긴 하겠네
        for (String s : polynomial.split(" ")) {
            if (s.contains("x")) {
                xCount += s.equals("x") ? 1 : Integer.parseInt(s.replaceAll("x", ""));
            } else if (!s.equals("+")) {
                num += Integer.parseInt(s);
            }
        }
        return (xCount != 0 ? xCount > 1 ? xCount + "x" : "x" : "")
        + (num != 0 ? (xCount != 0 ? " + " : "") + num : xCount == 0 ? "0" : "")

     */
    public String solution(String polynomial) {
        String answer = "";
        int xValue = 0;
        int numValue = 0;
        String[] split = polynomial.split(" \\+ ");
        Map<Boolean, List<String>> grouping = Arrays.stream(split)
                .collect(Collectors.groupingBy(s -> s.contains("x")));

        if(grouping.containsKey(true)) {
            xValue = grouping.get(true).stream()
                    .map(s -> {
                        if (s.length() > 1) {
                            return Integer.parseInt(s.substring(0, s.length() -1));
                        }
                        return 1;
                    })
                    .mapToInt(i -> i)
                    .sum();
        }

        if(grouping.containsKey(false)) {
            numValue = grouping.get(false).stream()
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

        if(xValue > 1) {
            answer += xValue;
            answer += "x";
        }else if(xValue == 1) {
            answer += "x";
        }

        if(numValue != 0) {
            if(answer.contains("x")) {
                answer += " + ";
            }
            answer += numValue;
        }

        return answer;
    }

}
