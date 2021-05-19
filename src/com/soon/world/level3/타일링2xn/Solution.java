package com.soon.world.level3.타일링2xn;


import java.util.Arrays;

/*
 * DP 문제 인거 같음
 * 피보나치 수열 생각 해내는 게 어려움
 * 자세한 설명 : https://deveric.tistory.com/61 에서 참고
 */
public class Solution {
    public int solution(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,0);
        dp[0] = 1;
        dp[1] = 2;

        for(int i=2; i<n; i++) {
            int num = dp[i-1] + dp[i-2];
            dp[i] = num %  1000000007 ;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int test = 4;
        System.out.println(solution.solution(test));
    }
}
