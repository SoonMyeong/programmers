package basic.조건에맞게수열변환하기2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {
    @Test
    void 조건에맞게_수열_변환하기2() {
        Assertions.assertThat(solution(new int[]{1, 2, 3, 100, 99, 98}))
                .isEqualTo(5);
    }

    /*
        문제 : 조건에 맞게 수열 변환하기 2
        https://school.programmers.co.kr/learn/courses/30/lessons/181881

        접근방법 :
        작업 전 배열 temp 를 만들고 arr 원소들을 복사 한다.
        그 후 arr 배열에 대해 작업을 진행 하고,
        temp 배열과 작업 후 arr 을 비교해서
        값이 똑같으면 반복 횟수인 answer 를 리턴 하면 될 거 같음

        베스트풀이 확인:
         나는 입출력예제를 보고 배열 전체를 기준으로 잡아서 계산했는데
         추천 수 가장 많은 풀이는 배열에 있는 각 원소 하나씩 값을 변경 시키면서
         변경되지 않을 때까지의 count 들을 배열로 모아서 그 count 값들 중
         가장 큰 값을 리턴하게끔 구현했음.
         접근방식을 원소 하나로 했다는게 신박함ㅋ
         나머지 풀이는 나랑 거의 비슷함
     */
    public int solution(int[] arr) {
        int answer = 0;
        int[] temp = new int[arr.length];

        while(true) {
            System.arraycopy(arr, 0, temp, 0, arr.length);
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    arr[i] /= 2;
                }
                if (arr[i] < 50 && arr[i] % 2 != 0) {
                    arr[i] = (arr[i] * 2) + 1;
                }
            }
            if(Arrays.equals(temp, arr)) {
                break;
            }
            answer++;
        }
        return answer;
    }
}
