package basic.일로만들기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 일로_만들기() {
        Assertions.assertThat(solution(new int[] {12,4,15,1,14})).isEqualTo(11);
    }

    /*
        문제 : 1로 만들기
        https://school.programmers.co.kr/learn/courses/30/lessons/181880

        문제 접근 :
        홀수냐 짝수냐에 따라 계속 반으로 나눠서 몫이 1이 될 때 까지
        나눈 총 횟수를 구하는 문제다.
        1일 경우는 바로 건너뛰도록 하고, 나머지는 홀/짝에 따라 문제에 나온
        조건을 구현하면 될 거 같음

        베스트풀이 확인 :
        언어의 원리 이용한 풀이가 있음. 이건 좋은듯
        num 값이 홀수건 짝이건 어차피 int 타입이라 홀수일 때 굳이 -1 하고 안나눠도 됨.
        why? 예를들어 3일 때 반으로 쪼개면 int 타입이라 몫은 1이 나옴. 굳이 -1 하고 안나눠도 됨.
     */
    public int solution(int[] num_list) {
        int answer = 0;

        for(int num : num_list) {
            while(num != 1) {
                if(num % 2 != 0) {
                    num--;
                }
                num /= 2;
                answer++;
            }
        }

        return answer;
    }

}
