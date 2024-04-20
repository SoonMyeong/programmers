package basic.전국대회선발고사;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution {
    @Test
    void 전국대회선발고사() {
        Assertions.assertThat(solution(new int[] {3,7,2,5,4,6,1}, new boolean[] {false,true,true,true,true,false,false}))
                .isEqualTo(20403);
        Assertions.assertThat(solution(new int[] {1,2,3}, new boolean[] {true,true,true}))
                .isEqualTo(102);
        Assertions.assertThat(solution(new int[] {6,1,5,2,3,4}, new boolean[] {true,false,true,false,false,true}))
                .isEqualTo(50200);

        Assertions.assertThat(solution2(new int[] {3,7,2,5,4,6,1}, new boolean[] {false,true,true,true,true,false,false}))
                .isEqualTo(20403);
        Assertions.assertThat(solution2(new int[] {1,2,3}, new boolean[] {true,true,true}))
                .isEqualTo(102);
        Assertions.assertThat(solution2(new int[] {6,1,5,2,3,4}, new boolean[] {true,false,true,false,false,true}))
                .isEqualTo(50200);
    }

    /*
        문제 : 전국대회선발고사
        https://school.programmers.co.kr/learn/courses/30/lessons/181851

        접근방법>
        제한사항에서 내가 스스로 검증해야 할 부분을 많이 제외시켜줬음
        길이도 최대 100으로 상당히 짧다.
        Map 자료구조로 rank 매핑 시켜놓고 
        attendance 원소 값이 true 인 애들만 찾아다 처리하면 될거 같은데...(solution2)

        근데 이건 암만봐도 Top-K 문제임.
        Top-K 문제는 힙 자료구조를 이용해 해결 해야 함.
        -> 근데 풀고나니 상대적으로 느려터짐, 길이 100인데 굳이 정렬하면서 집어넣을 필요가 있나 싶음 (힙은 원소를 정렬하면서 넣음)
        -> 사이즈가 엄청 큰 단위면 무조건 Top-K가 맞음. 근데 이건 사이즈 작음.


        베스트답안 확인>
        스트림으로 쭉 나열해서 푸는거... 음 별로.. 가독성 구림
        힙으로 푸는 문제 있음 OK
     */
    public int solution(int[] rank, boolean[] attendance) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(i -> rank[i]));
        for(int i = 0; i < attendance.length; i++) {
            if(attendance[i]) {
                queue.add(i);
            }
        }

        int a = 0;
        int b = 0;
        int c = 0;
        if(queue.peek() != null) {
            a = queue.poll();
        }
        if(queue.peek() != null) {
            b = queue.poll();
        }
        if(queue.peek() != null) {
            c = queue.poll();
        }

        return (10000 * a) + (100 * b) + c;
    }

    public int solution2(int[] rank, boolean[] attendance) {
        Map<Integer, Integer> mapping = new HashMap<>();
        for(int i = 0; i<rank.length; i++) {
            mapping.put(rank[i], i);
        }
        List<Integer> winners = new ArrayList<>();
        for(int i = 0; i< attendance.length; i++) {
            if(attendance[i]) {
                winners.add(rank[i]);
            }
        }
        Collections.sort(winners);
        int a = mapping.get(winners.get(0));
        int b = mapping.get(winners.get(1));
        int c = mapping.get(winners.get(2));

        return (10000 * a) + (100 * b) + c;
    }

}
