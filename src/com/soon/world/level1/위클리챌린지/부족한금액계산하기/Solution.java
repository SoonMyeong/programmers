package com.soon.world.level1.위클리챌린지.부족한금액계산하기;

public class Solution {

    public long solution(int price, int money, int count) {
        long answer = 0;

        for(int i=1; i<=count; i++) {
            answer += (long) price *i;
        }

        return answer > money ? answer-money : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int price = 3;
        int money = 20;
        int count = 4;
        System.out.println(solution.solution(3,20,4));
    }
}
