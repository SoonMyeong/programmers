package introduction.최댓값만들기1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {
    @Test
    void 최댓값만들기1() {
        Assertions.assertThat(solution(new int[] {1,2,3,4,5})).isEqualTo(20);
        Assertions.assertThat(solution(new int[] {0,31,24,10,1,9})).isEqualTo(744);
    }

    /*
        문제 : 최댓값 만들기
        -> 배열에서 원소 2개로 만들 수 있는 곱 중 가장 큰 값 찾기
        문제 유형 : Array, 최대/최솟값 찾기
        -> 해당 유형 자주 나오는 유형이므로 설명 예정
        접근 방법 :
        정렬한 뒤 맨 마지막 두 수의 곱이 최대가 될 수 밖에 없으므로
        선 정렬 후 계산으로 접근

     */
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length - 2] * numbers[numbers.length -1];
    }
}
