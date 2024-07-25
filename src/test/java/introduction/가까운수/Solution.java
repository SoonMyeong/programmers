package introduction.가까운수;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution {
    @Test
    void 가까운수() {
        Assertions.assertThat(solution(new int[] {10,11,12},13)).isEqualTo(12);
    }

    /*
        문제 : 가까운 수
        https://school.programmers.co.kr/learn/courses/30/lessons/120890
        접근 방법 :
        배열을 순회하면서 원소 - n 의 절대값이 가장 작은 걸 찾은 뒤
        그 작은 값의 배열 원소를 찾으면 된다.
        array 원소를 다시 찾는 과정과 정렬하는 과정을 줄이기 위해
        힙 자료구조와 맵 자료구조를 이용해본다.

        좋아요 많은 풀이 :
         array 를 일단 정렬 하고 난 뒤
         절대값 비교하면서 가장 작은 값을 array[0] 위치에 넣어두게 해서 계산하고 있음.
         개인적으로는 별로임, 왜냐 나도 문제 읽자마자 드는 생각은 이렇게 생각했기 때문.
         한번 더 생각하면 힙+정렬을 통해 풀이가 좀 더 단순해 질 수 있음

     */
    public int solution(int[] array, int n) {
        PriorityQueue<Map<Integer,Integer>> queue = new PriorityQueue<>(
                (m1, m2) -> {
                    Map.Entry<Integer, Integer> e1 = m1.entrySet().iterator().next();
                    Map.Entry<Integer, Integer> e2 = m2.entrySet().iterator().next();
                    if(e1.getValue().compareTo(e2.getValue()) != 0) {
                        return e1.getValue().compareTo(e2.getValue());
                    }else {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                });
        for (int i : array) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(i, Math.abs(i - n));
            queue.add(map);
        }

        return queue.poll().entrySet().iterator().next().getKey();
    }

}
