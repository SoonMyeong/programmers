package com.soon.world.level3.보석쇼핑;

/**
 *
 * 투포인터 방식이나 슬라이딩윈도우 알고리즘으로 해결 할 수 있는 문제
 *
 * 나는 슬라이딩윈도우 알고리즘으로 해결해 볼 생각.
 *
 */
public class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        return answer;
    }


    public static void main(String[] args) {
        String[] gems = {"AA", "AB", "AC", "AA", "AC"};
        Solution solution = new Solution();
        int[] result = solution.solution(gems);

        for (int res : result) {
            System.out.println(res);
        }
    }
}
