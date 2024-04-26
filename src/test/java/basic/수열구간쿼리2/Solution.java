package basic.수열구간쿼리2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    @Test
    void 수열과_구간_쿼리2() {
        Assertions.assertThat(solution(new int[]{0, 1, 2, 4, 3},new int[][]{{0, 4, 2},{0, 3, 2},{0, 2, 2}} ))
                .isEqualTo(new int[] {3,4,-1});

    }

    /*
        문제 : 수열과 구간 쿼리2
        https://school.programmers.co.kr/learn/courses/30/lessons/181923

        접근방법>
        arr 인덱스 범위가 쿼리[0] <= i <= 쿼리[1] 이고 쿼리[2]보다 크면서 가장 작은 arr[i] 구하기
        범위만큼의 인덱스들 중 쿼리[2]보다 큰애들만 따로 모아서 정렬 하면? 가장 첫번째 원소가 됨
        쿼리[2]보다 큰애가 없으면? 정렬할 컬렉션 비어있을 거고 -1 셋팅

        베스트풀이 확인>
        내 풀이 같은 경우 공간복잡도가 생기게 된다. (temp 리스트)
        베스트 풀이는 공간 복잡도를 안쓰고
        answer 배열을 -1로 셋팅 후 삼항연산자를 활용 해 해결했다.
        if (arr[j] > query[2]) {
            answer[i] = answer[i] == -1 ? arr[j] : Math.min(answer[i], arr[j]);
        }
        현재 나의 풀이의 경우 최악케이스를 고려하면 temp 리스트 정렬 시간도 무시할 수 없기 때문에
        주어진 문제의 arr 범위가 컸다면 타임오버가 났을 것이다.
     */
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];

        int i = 0;
        for (int[] query : queries) {
            List<Integer> temp = new ArrayList<>();
            for (int j = query[0]; j <= query[1]; j++) {
                if (arr[j] > query[2]) {
                    temp.add(arr[j]);
                }
            }
            temp.sort(Comparator.naturalOrder());

            if(temp.isEmpty()) {
                answer[i] = -1;
            }else {
                answer[i] = temp.get(0);
            }
            i++;
        }

        return answer;
    }

}
