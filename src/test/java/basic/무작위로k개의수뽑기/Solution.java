package basic.무작위로k개의수뽑기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    @Test
    void 무작위로_k개의_수_뽑기() {
        Assertions.assertThat(solution(new int[]{0, 1, 1, 2, 2, 3}, 3)).isEqualTo(new int[]{0,1,2});
        Assertions.assertThat(solution(new int[]{0,1,1,1,1}, 4)).isEqualTo(new int[]{0,1,-1,-1});
        Assertions.assertThat(solution(new int[]{0,1,2}, 3)).isEqualTo(new int[]{0,1,2});
        Assertions.assertThat(solution(new int[]{0,1,2}, 4)).isEqualTo(new int[]{0,1,2,-1});
        Assertions.assertThat(solution(new int[]{3,2,1}, 4)).isEqualTo(new int[]{3,2,1,-1});
        Assertions.assertThat(solution(new int[]{0,1,3,2}, 4)).isEqualTo(new int[]{0,1,3,2});
        Assertions.assertThat(solution(new int[]{0,1,3,2}, 3)).isEqualTo(new int[]{0,1,3});
        Assertions.assertThat(solution(new int[]{0,1,0,1}, 4)).isEqualTo(new int[]{0,1,-1,-1});
    }

    /*
        문제 : 무작위로 k개의 수 뽑기
        https://school.programmers.co.kr/learn/courses/30/lessons/181858

        접근방법>
        arr 배열 을 순회하는데 서로다른 수를 저장하는 배열에 arr 배열의 원소가 있는지를 체크해야한다.
        없으면 값을 추가하고... 단순 배열만 가지고는 복잡할거 같은데
        큐를 쓰면 쉽게 해결될 거 같음. 대신 시간복잡도가 2N이 되겠지만..

        answer 배열은 k 공간으로 할당하고 초기값 -1로 셋팅
        첫 원소를 queue 에 넣는다.
        두번째 arr 원소부터 queue 에 해당 arr 원소 값을 포함하고 있으면 패스 다르면 추가
        다 끝나면 큐에 있는거 다 빼서 배열에 넣고 끝

        베스트풀이 확인>
        오호.. arr은 중복 제거하고, default 값인 -1을 만들어낼 배열사이즈인 k 만큼 -1로
        셋팅해놓은 다음에 중복제거한 arr 과 default 를 붙여놓고 그걸 k만큼만 꺼내서 배열로 만듬
        IntStream default = IntStream.range(0, k).map(i -> -1);

        IntStream.concat(Arrays.stream(arr).distinct(), default)
                 .limit(k)
                 .toArray();

     */
    public int[] solution(int[] arr, int k) {
        int[] answer = new int [k];
        Arrays.fill(answer, -1);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(arr[0]);


        for(int i =1; i<arr.length; i++) {
            if(!queue.contains(arr[i])) {
                queue.offer(arr[i]);
            }
        }
        int i = 0;
        while(i< k && !queue.isEmpty()) {
            answer[i] = queue.poll();
            i++;
        }

        return answer;
    }
}
