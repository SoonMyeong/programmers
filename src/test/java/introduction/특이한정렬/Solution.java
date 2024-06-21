package introduction.특이한정렬;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    @Test
    void 특이한정렬() {
        Assertions.assertThat(solution(new int[] {1,2,3,4,5,6}, 4))
                .isEqualTo(new int[] {4,5,3,6,2,1});
        Assertions.assertThat(solution(new int[] {10000,20,36,47,40,6,10,7000}, 30))
                .isEqualTo(new int[] {36,40,20,47,10,6,7000,10000});
    }

    /*
        문제 : 특이한 정렬
        https://school.programmers.co.kr/learn/courses/30/lessons/120880
        접근 방법 :
        정렬의 규칙을 찾아야되는 문제이다.
        주어진 수 n 에서 numlist 의 모든 원소를 뺀 절대값들로 배열을 구성한 후
        그 배열을 오름차순 정렬한 다음 각 원소에 해당하는 원래 numlist 의 원소로 구성하면 된다.
        단, 오름차순 정렬 시 값이 같을 경우 원래 numlist 의 값이 더 큰 값이 앞에 오게 하면 된다.
        ex) numlist = [1,2,3,4,5,6] , n = 4
        n - numlist 원소값 의 절대값들로 구성한 배열 : [0,1,1,2,2,3]
        같은 1,1의 경우 원래 numlist 원소값인 3과 5가 되고 더 큰값인 5가 먼저 나와야 함
        같은 2,2의 경우 원래 numlist 원소값인 2와 6이 되고 더 큰값인 6이 먼저 나와야 함
        객체하나 만들어서 해도되고... 그냥 Map 으로 해도 되고..
        Map 으로 하면 method 체이닝이 좀 길어지긴하는데.. 그냥 Map 으로 함 객체만들기도 귀찮

        좋아요 많은 풀이 :
        맵으로 푼 사람도 있고 객체로 푼 사람도 있고 힙으로 푼사람도 있고..
        numlist 를 그대로 스트림으로 굴렸으면.. 굳이 List<Map>> 형태로 안해도 됐었네 쩝,
        .sorted((a, b)
        -> Math.abs(a - n) == Math.abs(b - n) ? b.compareTo(a) : Integer.compare(Math.abs(a - n), Math.abs(b - n)))
     */
    public int[] solution(int[] numlist, int n) {
        List<Map<Integer,Integer>> answer = new ArrayList<>();
        for(int i = 0; i<numlist.length; i++) {
            Map<Integer,Integer> map = new HashMap<>();
            map.put(Math.abs(n-numlist[i]), i);
            answer.add(map);
        }

        return answer.stream()
                .sorted((a,b) -> {
                    if(a.keySet().stream().iterator().next().intValue()
                            == b.keySet().stream().iterator().next().intValue()) {
                        return numlist[b.values().iterator().next()] - numlist[a.values().iterator().next()];
                    }
                    return a.keySet().stream().iterator().next() - b.keySet().stream().iterator().next();
                })
                .map(m -> numlist[m.values().iterator().next()])
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
