package basic.배열_조각하기;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    @Test
    void 배열조각하기() {
        int[] res = solution(new int[]{0, 1, 2, 3, 4, 5}, new int[]{4, 1, 2});
        Assertions.assertThat(res[0]).isEqualTo(1);
        Assertions.assertThat(res[1]).isEqualTo(2);
        Assertions.assertThat(res[2]).isEqualTo(3);

    }

    @Test
    void copyOfRange_출력하여_확인() {
        //start : 복사 시작 인덱스
        //end: 복사할 마지막 인덱스 + 1
        Assertions.assertThat(Arrays.copyOfRange(new int[]{0, 1, 2, 3, 4, 5}, 1,4)[0]).isEqualTo(1);
        Assertions.assertThat(Arrays.copyOfRange(new int[]{0, 1, 2, 3, 4, 5}, 1,4)[1]).isEqualTo(2);
        Assertions.assertThat(Arrays.copyOfRange(new int[]{0, 1, 2, 3, 4, 5}, 1,4)[2]).isEqualTo(3);
    }

    /*
    문제: 배열 조각하기
    https://school.programmers.co.kr/learn/courses/30/lessons/181893

    접근방법>
    제한사항은 딱히 고려 안해도 될 거 같음
    짝수 인덱스 > query[i] 번 인덱스 제외 query[i] 인덱스 앞부분 제거
    홀수 인덱스 > query[i] 번 인덱스 제외 query[i] 인덱스 뒷부분 제거
    배열을 순회하면서 원소 제거를 반드시 해야 최종 query 결과를 질의 할 수 있음
    범위 제거가 쉽도록 컬렉션을 활용

    1. 배열 -> List 변경
    2. 짝,홀 범위에 맞게 subList  로 범위 잡은 뒤 해당 부분 clear()
    3. List -> 배열 변경
    공간 복잡도 : 1
    시간 복잡도 : N

    베스트 풀이 확인>
    처음과 끝 값만 알아 낸 뒤
    그 범위 만큼만 Arrays.copyOfRange(arr, start, end + 2)
    +2 = (슬라이싱 끝나는위치 포함하기 위한 +1 , array 복사 범위 끝 포함하기 위한 +1)

    내 풀이보다 코드가 더 간결함. 근데 직관적이진 않음
    */
    public int[] solution(int[] arr, int[] query) {
        /*
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i< arr.length; i++) {
                list.add(arr[i]);
            }
        */
        List<Integer> list = Arrays.stream(arr)
                .boxed().collect(Collectors.toList());

        for(int i = 0; i<query.length; i++) {
            int idx = query[i];
            if(i % 2 == 0) {
                list.subList(idx+1, list.size()).clear();
            }
            if(i % 2 != 0) {
                list.subList(0, idx).clear();
            }
        }

        return list.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}
