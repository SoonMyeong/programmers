package introduction.삼육구게임;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {
    @Test
    void 삼육구게임() {

    }

    /*
        문제 : 369게임
        https://school.programmers.co.kr/learn/courses/30/lessons/120891
        접근 방법 :
        이거머여... 그냥 3,6,9 포함하는거 개수 구하면 되나..?
        좋아요 많은 풀이 :
        ㅇㅇ 맞음..
     */
    public int solution(int order) {
        int answer = 0;
        return (int) Arrays.stream(String.valueOf(order)
                .split(""))
                .filter(s -> s.equals("3") || s.equals("6") || s.equals("9"))
                .count();
    }
}
