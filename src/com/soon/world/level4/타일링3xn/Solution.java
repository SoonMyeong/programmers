package com.soon.world.level4.타일링3xn;

import java.util.Arrays;

/**
 * dp[i-2]+ 3^n -1 일줄 알았는데.. 아니네..
 * 이거 4n 까지 생각해야 되는게.. 어렵네..
 */
public class Solution {
    public int solution(int n) {
       long[] dp = new long[5001];
       Arrays.fill(dp,0);
       dp[0] = 1;
       dp[2] = 3;

       if(n%2 !=0) {
           return 0;
       }

       for(int i=4; i<=n; i+=2) {
           dp[i] = dp[i-2]*3;
           for(int j=i-4; j>=0; j-=2) {
               dp[i] += (dp[j] *2) %  1000000007 ;
           }
       }
        return (int) dp[n] %  1000000007 ;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int test = 4;
        System.out.println(solution.solution(test));
    }
}
