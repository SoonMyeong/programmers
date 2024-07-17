package introduction.컨트롤제트;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Solution {
    @Test
    void 컨트롤제트() {
        Assertions.assertThat(solution("1 2 Z 3")).isEqualTo(4);
    }

    /*
        문제 : 컨트롤 제트
        https://school.programmers.co.kr/learn/courses/30/lessons/120853
        접근 방법 :
        가장 마지막에 넣은걸 먼저 빼서 작업해야 한다? LIFO 하면? Stack
        String s 를 공백 기준으로 짤라 그 배열을 순회하면서 값을 더해주면서
        Stack 에 넣어두고 "Z" 를 만날 때 stack 에서 가장 마지막에 넣은 숫자 빼버리고..
        그 숫자만큼 answer 에서 뺴주면 됨

        좋아요 많은 풀이 :
        stack 이용한점은 나랑 똑같은데, 얘네는 split() 순회 끝나고 스택을 또 순회하고 있음..
        내 풀이가 더 시간복잡도가 좋음
     */
    public int solution(String s) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        String[] data = s.split(" ");
        for(String str : data) {
            if("Z".equals(str)) {
                int lastNum = stack.peek();
                stack.pop();
                answer -= lastNum;
            }else {
                int n = Integer.parseInt(str);
                stack.push(n);
                answer += n;
            }
        }

        return answer;
    }
}
