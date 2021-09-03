package com.soon.world.level2.피보나치;

public class Solution {

    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n+1];

        dp[2] = 1;
        dp[3] = 2;

        for(int i=4; i<=n; i++) {
            dp[i] = (dp[i-1]+dp[i-2])%1234567;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 100000;
        System.out.println(solution.solution(n));
    }
}
