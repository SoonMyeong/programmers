package introduction.등수매기기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution {
    @Test
    void 등수매기기() {
        Assertions.assertThat(solution(new int[][]{{80, 70}, {90, 50}, {40, 70}, {50, 80}}))
                .isEqualTo(new int[] {1,2,4,3});
        Assertions.assertThat(solution(new int[][]{{1, 1}, {1, 2}}))
                .isEqualTo(new int[] {2,1});
    }

    /*
        문제 : 등수 매기기
        https://school.programmers.co.kr/learn/courses/30/lessons/120882

     */
    public int[] solution(int[][] score) {
        List<Double> answer = new ArrayList<>();
        List<Double> list = new ArrayList<>();
        for(int[] s : score) {
            double avg = (s[0] + s[1]) / 2.0;
            list.add(avg);
        }
        list.sort(Comparator.reverseOrder());

        for(int[] s : score) {
            double avg = (s[0] + s[1]) / 2.0;
            answer.add(list.indexOf(avg) + 1.0);
        }
        return answer.stream()
                .mapToInt(Double::intValue)
                .toArray();
    }
}
