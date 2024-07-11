package introduction.공던지기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 공던지기() {
        Assertions.assertThat(solution(new int[] {1,2,3,4}, 2)).isEqualTo(3);
        Assertions.assertThat(solution(new int[] {1,2,3,4,5,6}, 5)).isEqualTo(3);
        Assertions.assertThat(solution(new int[] {1,2,3}, 3)).isEqualTo(2);
    }

    /*
        문제 : 공 던지기
        https://school.programmers.co.kr/learn/courses/30/lessons/120843
        접근 방법 :
        싸이클을 찾아내야 싸이클 횟수를 k로 나누고 그 나머지를 직접 순회해야 시간복잡도가 확 줄어든다.
        싸이클을 찾을 땐 첫번째로 던지는 numbers[0] 위치로 공이 다시 돌아올 때 까지 계산해보면 된다.

        좋아요 많은 풀이 :
        return (k-1)*2 % numbers.length+1;
        결국 이 수식도 마찬가지로 (k-1)*2 % numbers.length 를 하게 되면
        k번째 던진 위치(인덱스) 가 나온다. 근데 인덱스 값이 아니라 numbers[i] 값을 구해야하므로 +1 해준것
        싸이클을 그냥 (k-1)*2 % numbers.length 인 수식으로 구할 수 있었음..
     */
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int idx = 0;
        int cycleCount = 0;

        while(true) {
            if(idx == numbers.length - 1) {
                idx = 1;
            }else if(idx == numbers.length - 2) {
                idx = 0;
            }else {
                idx+=2;
            }
            cycleCount++;
            if(idx == 0) {
                break;
            }
        }
        int calculate = Math.max(k, cycleCount) % Math.min(k, cycleCount);
        if(calculate == 0) {
            calculate = cycleCount;
        }

        int resultIdx = 0;
        for(int i = 0; i < calculate -1; i++) {
            if(resultIdx == numbers.length - 1) {
                resultIdx = 1;
            }else if(resultIdx == numbers.length - 2) {
                resultIdx = 0;
            }else {
                resultIdx+=2;
            }
        }
        return numbers[resultIdx];
    }
}
