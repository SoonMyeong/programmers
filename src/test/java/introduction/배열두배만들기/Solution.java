package introduction.배열두배만들기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 배열_두배_만들기() {
        Assertions.assertThat(solution(new int[] {1,2,3,4,5}))
                .isEqualTo(new int[] {2,4,6,8,10});
    }

    /*
        문제 : 배열 두배 만들기
        https://school.programmers.co.kr/learn/courses/30/lessons/120809
        접근 방법 :
        배열 원소들 모두 *2 해주면 된다.
        좋아요 많은 풀이 :
         Arrays.stream(numbers).map(i -> i * 2).toArray();
     */
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i = 0; i<answer.length; i++) {
            answer[i] = numbers[i] * 2;
        }
        return answer;
    }
}
