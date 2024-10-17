package study.hash;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution670 {
    @Test
    void test() {
        Assertions.assertThat(maximumSwap(2736)).isEqualTo(7236);
    }

    /**
     *
     * https://leetcode.com/problems/maximum-swap/?envType=daily-question&envId=2024-10-17
     * 입력받은 숫자에서 숫자 자리를 한번만 바꿀 수 있을 때 구할 수 있는 최대 값 구하기
     * 1. 브루트포스로 접근
     *  - 이중루프 돌면서 하나하나 다 바꿔보기 (여기서 이미 문제는 풀림)
     * 2. 탐욕법 (그리디)
     * - 최적화.. 솔루션이랑 교육 읽다가 일단 덮음. 다들 저런 최적화 생각을 어떻게하지ㅠ ㅋㅋ
     * @param num
     * @return
     */
    public int maximumSwap(int num) {
        var str = Integer.toString(num);
        var max = num;
        if(str.toCharArray().length == 1) {
            return num;
        }
        for(int i = 0; i<str.length(); i++) {
            String swapped = "";
            for(int j = i+1; j < str.length(); j++) {
                var numArray = str.toCharArray();
                var temp = numArray[i];
                numArray[i] = numArray[j];
                numArray[j] = temp;
                swapped = new String(numArray);
                max = Math.max(max, Integer.parseInt(swapped));
            }
        }
        return max;
    }
}
