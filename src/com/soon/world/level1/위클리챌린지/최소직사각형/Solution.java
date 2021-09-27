package com.soon.world.level1.위클리챌린지.최소직사각형;

public class Solution {

    /**
     * 명함 사이즈들을 받아서 명함들을 다 집어넣을 수 있는 가장 작은 지갑 만들기
     * 단, 명함은 가로와 세로를 바꿀 수 있다. (예를들어 명함을 세로로 넣을거를 가로로 넣는다)
     * 명함 | 가로 | 세로
     * 1 | 60 | 50
     * 2 | 30 | 70
     * 3 | 60 | 30
     * 4 | 80 | 40
     * -> 80 | 70
     * -> 8
     *
     * @param sizes
     * @return
     */
    public int solution(int[][] sizes) {
        int answer = 0;

        /**
         * 10 | 7   7 | 10
         * 12 | 3   3 | 12
         * 8 | 15   8 | 15
         * 14 | 7   7 | 14
         * 5 | 15
         * 14 | 15
         *
         *
         */

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution.solution(sizes));
    }
}
