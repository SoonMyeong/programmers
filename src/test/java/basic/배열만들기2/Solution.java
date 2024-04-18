package basic.배열만들기2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    void 배열만들기2() {
        int[] res = {5,50,55,500,505,550,555};
        Assertions.assertThat(solution(5,555)).containsExactly(res);
        Assertions.assertThat(solution(50,555)).hasSize(6);
        Assertions.assertThat(solution(1,5)[0]).isEqualTo(5);
    }

    /*
    문제: 배열만들기2
    https://school.programmers.co.kr/learn/courses/30/lessons/181921

    접근방법>
    "0" 이랑 "5"만 가지고 만드는 수
    이진수 처럼 접근 하되 0이랑 5를 조합해서 만들면 될거같음
    규칙 모름 ㅎ
    규칙을 좀 찾아보니 5 * 이진수 를 하면 0 과 5로 만들 수 있는 숫자만 나열할 수 있음 확인
    <규칙>
    5 ( 5 * 1의 이진수인 1)
    50 (5 * 2의 이진수인 10)
    55 (5 * 3의 이진수인 11)
    500 (5 * 4의 이진수인 100)
    505 (5 * 5의 이진수인 101)
    550 (5 * 6의 이진수인 110)
    ...

    베스트답안 확인>
    제한 숫자를 보고 범위를 지정할 수 있기에 나처럼 while(true) 인 무한루프를 걸 필요가 없음
    규칙은 내가 chatGPT 한테 물어본게 베스트였음
    */
    public int[] solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();
        int count = 1;
        while(true) {
            int fiveNumber = 5 * Integer.parseInt(Integer.toBinaryString(count));
            if(fiveNumber > r) {
                break;
            }
            if(l <= fiveNumber) {
                answer.add(fiveNumber);
            }
            count++;
        }

        if(answer.size() == 0) {
            return new int[] {-1};
        }

        return answer.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}
