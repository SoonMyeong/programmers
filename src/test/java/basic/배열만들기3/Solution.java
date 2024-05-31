package basic.배열만들기3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    void 배열만들기3() {
        Assertions.assertThat(solution(new int[]{1,2,3,4,5}, new int[][]{{1,3},{0,4}}))
                .isEqualTo(new int[] {2,3,4,1,2,3,4,5});
    }

    /*
        문제 : 배열만들기3
        https://school.programmers.co.kr/learn/courses/30/lessons/181895
        접근방법 :
        intervals 배열 원소 값이 arr 의 인덱스 시작,종료 범위의 값을 뜻함
        intervals 배열 원소 값으로 arr 범위 내 원소들을 계속 추가해주면 끝
        베스트풀이 확인 :
        보통 비슷하게 품
     */
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> answer = new ArrayList<>();

        for(int[] interval : intervals) {
            for(int i = interval[0]; i<=interval[1]; i++) {
                answer.add(arr[i]);
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
