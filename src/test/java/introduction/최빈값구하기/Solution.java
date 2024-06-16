package introduction.최빈값구하기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    @Test
    void 최빈값_구하기() {
        Assertions.assertThat(solution(new int[] {1,2,3,3,3,4})).isEqualTo(3);
        Assertions.assertThat(solution(new int[] {1,1,2,2})).isEqualTo(-1);
        Assertions.assertThat(solution(new int[] {1})).isEqualTo(1);
        Assertions.assertThat(solution(new int[] {1,1,1,1,1})).isEqualTo(1);
    }

    /*
        문제 : 최빈값 구하기
        https://school.programmers.co.kr/learn/courses/30/lessons/120812
        접근 방법 :
        최빈값 : 주어진 배열에서 가장 자주 나오는 값
        map 자료구조를 이용해서 각 원소들과 (key) 그 개수들(value) 를 채우면서
        최대힙으로 구성해서 맨 처음 뺀 값과 그 다음값이랑 값이 같으면 최빈값이 여러개이므로 -1
        그 외에는 맨 처음 값의 key 값 리턴 하면 될듯

        좋아요 많은 풀이 :
        int maxCount = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int number : array){
            int count = map.getOrDefault(number, 0) + 1;
            if(count > maxCount){
                maxCount = count;
                answer = number;
            }
            else  if(count == maxCount){
                answer = -1;
            }
            map.put(number, count);
        }
        return answer;
        map 에 집어넣으면서 최대값을 같이 구하고 있고
        최대값과 같은게 있다면 -1로 셋팅, 하지만 그 이후로 최대값이 바뀔 때 answer 값도 변경해줌으로써
        결국 최대값이 같은게 있다면 answer 는 -1이 될것이고 아니면 최빈값으로 바뀌어져 문제를 해결할 수 있다.
        결국 내 풀이는 시간복잡도가 n+logn 인데 n만에 풀어낸 풀이니까 이 풀이가 시간복잡도 측면에서는 더 좋다.
        근데 난 내 풀이가 좋다. ㅋㅋ 내께 더 심플한거같은디...
     */
    public int solution(int[] array) {
        PriorityQueue<Map<Integer, Integer>> queue
                = new PriorityQueue<>((m1, m2) -> Integer.compare(m2.values().iterator().next(), m1.values().iterator().next()));
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : array) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        if(map.size() == 1) {
            return map.keySet().iterator().next();
        }

        for(Integer i :map.keySet()) {
            Map<Integer, Integer> resultMap = new HashMap<>();
            resultMap.put(i, map.get(i));
            queue.add(resultMap);
        }

        Map<Integer, Integer> poll = queue.poll();
        int resultValue = poll.values().iterator().next();

        return resultValue == queue.peek().values().iterator().next() ? -1 : poll.keySet().iterator().next();
    }
}
