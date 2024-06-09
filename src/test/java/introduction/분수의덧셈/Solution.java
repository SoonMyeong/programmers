package introduction.분수의덧셈;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 분수의덧셈() {
        Assertions.assertThat(solution(1	,2,	3,	4))
                .isEqualTo(new int[] {5,4});
        Assertions.assertThat(solution(9	,2,	1,	3))
                .isEqualTo(new int[] {29,6});
    }

    /*
        문제 : 분수의 덧셈
        https://school.programmers.co.kr/learn/courses/30/lessons/120808
        접근 방법 :
        1. 두 분모가 같으면 그대로 덧셈하여 계산
        2. 두 분모가 다르면?
        - 두 수의 최소공배수를 구하고 최소공배수를 만들기 위해 곱해야 하는 수만큼 분자에도 곱해줘서 계산
        - 최대공약수는 호클리드로제 알고리즘 쓰면 쉽게 구하고, 최소공배수는 두 수가 있을 때
        (a*b) /gcd 가 최소공배수가 됨
        3. 기약분수로 나타내야되므로 최대한 약분 해준다.

        좋아요 많은 풀이 :
        내 풀이의 경우 두 분모가 같은지 아닌지 체크하는 로직을 나눠서 계산했는데
        가독성좀 괜찮아보이는 코드보니 일단 분모가 다르다고 가정하고 계산하는 로직으로 해결
        최대공약수로 나눠주면 그 이후로는 더 안나눠지니까 기약분수가 되니.. 괜찮은 풀이라고 보여진다.

     */
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];

        if(denom1 == denom2) {
            answer[0] = numer1 + numer2;
            answer[1] = denom1;
            return calculateReduce(answer);
        }

        int lcm = (denom1 * denom2) / gcd(denom1, denom2);
        answer[0] = numer1 * (lcm/denom1) + numer2 * (lcm/denom2);
        answer[1] = lcm;

        return calculateReduce(answer);
    }

    private int[] calculateReduce(int[] answer) {
        while(true) {
            int gcd = gcd(answer[0], answer[1]);
            if(gcd == 1 || (answer[0] % gcd != 0 || answer[1] % gcd != 0)) {
                break;
            }
            answer[0] /= gcd;
            answer[1] /= gcd;
        }
        return answer;
    }

    private int gcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return gcd(num2, num1 % num2);
    }
}
