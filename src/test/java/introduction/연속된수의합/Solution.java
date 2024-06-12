package introduction.연속된수의합;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class Solution {
    @Test
    void 연속된_수의_합() {
        Assertions.assertThat(solution(3,12)).isEqualTo(new int[] {3,4,5});
        Assertions.assertThat(solution(5,15)).isEqualTo(new int[] {1,2,3,4,5});
        Assertions.assertThat(solution(4,14)).isEqualTo(new int[] {2,3,4,5});
        Assertions.assertThat(solution(5,5)).isEqualTo(new int[] {-1,0,1,2,3});
        Assertions.assertThat(solution(4,10)).isEqualTo(new int[] {1,2,3,4});
    }
    
    /*
        문제  : 연속된 수의 합
        https://school.programmers.co.kr/learn/courses/30/lessons/120923
        접근 방법 :
        이런 문제는 규칙을 찾아내야 풀 수 있다.
        입출력 예 1과,2 를 보면
        num = 3, total= 12 이면 [3,4,5]
        num = 5, total= 15 이면 [1,2,3,4,5] 가 된다.
        num = 5, total = 5 이면 [-1,0,1,2,3]
        눈치챘겠지만 num 이 홀수이면 total/num 값이 가운데 자리에 들어가게 된다.
        num 이 짝수인 경우를 보면
        num = 4, total = 14 이면 [2,3,4,5] 가 된다.
        눈치챘겠지만 total/num 이 절대 딱 떨어지면 안된다.
        나머지는 num 의 절반이여야 한다. total/num = 3, total%num = 2 (num 의 절반)
        그리고 몫이 num/2 -1 자리에 들어가게 된다. 즉 [,3,,] 이렇게 되고 연속된 수니까 채우면 [2,3,4,5]가 된다.
        num = 6, total = 21 이면, [1,2,3,4,5,6] 이 된다. total/num = 3, total%num = 3 (num의 절반)
        하나 더 구해보자.
        num = 8, total = 28 이면, [0,1,2,3,4,5,6,7]이 된다. total/num = 3, total%num = 4 (num의 절반)
        그대로 구현하면 되겠다.

        좋아요 많은 풀이 :
        나는 중간값을 보고 규칙을 찾아냈기 때문에 다소 식이 복잡해졌다.
        연속된수의 합을 구하는 식인 num*(num+1) / 2 와
        시작점을 구하는 ((total - check) / num) +1 을 도출해내면 상당히 쉽게 풀 수 있다..ㅎ

        int[] answer = new int[num];
        int check = num*(num+1) / 2;
        int start = (total - check) / num + 1;
        for (int i = 0; i < answer.length; i++) {
                answer[i] = start + i ;
        }
        return answer;

     */
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        if(num%2 == 0 && total%num == (num/2)) {
            int k = 0;
            for(int i =(num/2) -1; i>=0; i--) {
                answer[i] = (total/num) - k;
                k++;
            }
            k = 1;
            for(int i = num/2; i<answer.length; i++) {
                answer[i] = (total/num) + k;
                k++;
            }
        }
        if(num%2 != 0) {
            answer[(num/2)] = total/num;
            int k = 1;
            for(int i =(num/2) -1; i >=0; i--) {
                answer[i] = (total/num) -k;
                k++;
            }
            k = 1;
            for(int i = (num/2) +1; i<answer.length; i++) {
                answer[i] = (total/num) + k;
                k++;
            }
        }
        return answer;
    }
}
