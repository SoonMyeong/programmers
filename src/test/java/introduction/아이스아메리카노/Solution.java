package introduction.아이스아메리카노;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 아이스아메리카노() {
        Assertions.assertThat(solution(15000)).isEqualTo(new int[]{2,4000});
    }

    /*
        문제 : 아이스 아메리카노
        https://school.programmers.co.kr/learn/courses/30/lessons/120819
        접근 방법 :
        아아가 5500원이니까.. 가지고 있는돈 /5500 원의 몫과 나머지를 리턴 해주면됨
        좋아요 많은풀이:
        같음
     */
    public int[] solution(int money) {
        int[] answer = new int[2];
        answer[0] = money / 5_500;
        answer[1] = money % 5_500;
        return answer;
    }
}
