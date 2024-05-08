package basic.이의영역;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class Solution {
    @Test
    void 이의영역() {
        Assertions.assertThat(solution(new int[]{1, 2, 1, 4, 5, 2, 9})).isEqualTo(new int[] {2,1,4,5,2});
        Assertions.assertThat(solution(new int[]{1,2,1})).isEqualTo(new int[] {2});
        Assertions.assertThat(solution(new int[]{1,1,1})).isEqualTo(new int[] {-1});
        Assertions.assertThat(solution(new int[]{1, 2, 1, 2, 1, 10, 2, 1})).isEqualTo(new int[] {2, 1, 2, 1, 10, 2});
    }

    /*
        문제 : 2의 영역
        https://school.programmers.co.kr/learn/courses/30/lessons/181894
        접근방법 :
        배열에 2가 없으면 -1 리턴
        배열에서 2가 있는 인덱스가 2개라면 그 두 인덱스의 범위에 해당 하는 원소들 리턴
        배열에서 2가 있는 인덱스가 3개 이상 이면 가장 작은 인덱스와 가장 큰 인덱스의 범위에 해당하는 원소들 리턴
        배열에서 2가 있는 인덱스가 1개라면 해당 인덱스에 있는 원소만 출력 (2가 있는 인덱스를 찾는거니까 하나면 그냥 2 리턴하면 됨)

        2가 속한 인덱스들의 최소 값과 최대 값을 구해서 그 범위에 해당하는 원소들 배열로 리턴하면 될 거 같음
        초기 min 값 100000 : 제한사항 범위에서 arr 길이는 최대 100,000 이고 인덱스는 99,999 이므로 이보다 큰 수
        초기 max 값 0 : 제한사항 범위에서 arr 길이는 최소 1 이므로 이 보다 작은 수
        최소값 변화가 없으면 -1 리턴
        최소값과 최대값이 똑같으면 max 가 min 값으로 변한 후 값이 안바뀐 거라 인덱스가 1개 밖에없다는 거 2 리턴
        그 외 min 과 최대값+1 만큼 범위 배열 복사

        베스트풀이 확인 :
        최대 최소 이용을 안해서 for 문 2개 돌리는데 좋아요 많은거 보고
        좀 아쉬웠는데 네임드분인거 같은 한 분이 쓰셨네 굳굳
     */
    public int[] solution(int[] arr) {
        int max = 0;
        int min = 100_000;
        for(int i = 0; i<arr.length; i++) {
            if(arr[i] == 2) {
                max = Math.max(max, i);
                min = Math.min(min, i);
            }
        }
        if(min == 100_000) {
            return new int[] {-1};
        }
        if(max == min) {
            return new int[] {2};
        }

        return Arrays.copyOfRange(arr, min, max+1);
    }

}
