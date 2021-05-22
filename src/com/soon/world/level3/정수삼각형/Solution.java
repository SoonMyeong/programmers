package com.soon.world.level3.정수삼각형;

/**
 * dp 문제, 최대값 최소값 관련 해서 보통 dp 가 많이 나오는 편이라고 한다.
 */
public class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for(int i=1; i<triangle.length; i++) {
            for(int j=0; j<=i; j++) {
                if(j==0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if(j==i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + triangle[i][j];
                }
                answer = Math.max(answer,dp[i][j]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        System.out.println(solution.solution(test));
    }
}
