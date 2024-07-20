package introduction.진료순서정하기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    @Test
    void 진료순서정하기() {
        Assertions.assertThat(solution(new int[] {3,76,24})).isEqualTo(new int[] {3,1,2});
    }

    /*
        문제 : 진료 순서 정하기
        https://school.programmers.co.kr/learn/courses/30/lessons/120835
        접근 방법 :
        키,벨류 타입의 자료구조인 맵을 이용하기
        key : 응급도, value : 순위

        좋아요 많은 풀이 :
        희표좌 풀이: 배열 순회하면서 reverseOrder 한 리스트의 indexOf 로 인덱스 가져와서 +1 한 값을
        배열로 만들고 있음, 나머지는 나랑 같음.
     */
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        List<Integer> reserveSortedList = Arrays.stream(emergency)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        Map<Integer, Integer> map = IntStream.range(0, reserveSortedList.size())
                .boxed()
                .collect(Collectors.toMap(reserveSortedList::get, idx -> idx+1));

        for(int i = 0; i<answer.length; i++) {
            answer[i] = map.get(emergency[i]);
        }

        return answer;
    }
}
