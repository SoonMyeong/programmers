package introduction.가장큰수찾기;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    @Test
    void 가장큰수찾기() {

    }

    /*
        문제 : 가장 큰 수 찾기
        https://school.programmers.co.kr/learn/courses/30/lessons/120899
        접근 방법 :
        켈렉션 사용으로 풀기
        좋아요 풀이 :
        희표좌와 비슷
     */
    public int[] solution(int[] array) {
        List<Integer> collect = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());
        int[] answer = new int[2];

        answer[0] = Collections.max(collect);
        answer[1] = collect.indexOf(answer[0]);

        return answer;
    }

}
