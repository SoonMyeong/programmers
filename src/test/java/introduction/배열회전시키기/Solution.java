package introduction.배열회전시키기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 배열회전시키기() {
        Assertions.assertThat(solution(new int[] {1,2,3}, "right")).isEqualTo(new int[] {3,1,2});
    }

    /*
        문제 : 배열 회전시키기
        https://school.programmers.co.kr/learn/courses/30/lessons/120844

        접근 방법 :
        방향에 따라 한칸씩 옮겨주면 되는 문제임.
        여러 방법이 있을 거 같은데..
        그냥 왼쪽과 오른쪽 나눠서 한칸씩 옮기는걸로

        좋아요 많은 풀이 :
        거의 비슷함
     */
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];

        if("left".equals(direction)) {
            for(int i = numbers.length - 1; i > 0; i--) {
                answer[i-1] = numbers[i];
            }
            answer[answer.length -1] = numbers[0];

            return answer;
        }

        for(int i = 0; i < numbers.length -1; i++) {
            answer[i+1] = numbers[i];
        }
        answer[0] = numbers[numbers.length -1];

        return answer;
    }

}
