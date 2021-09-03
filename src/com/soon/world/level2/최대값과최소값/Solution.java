package com.soon.world.level2.최대값과최소값;

public class Solution {

    public String solution(String s) {
        String answer = "";

        String[] str = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(String num : str) {
            int n =Integer.parseInt(num);

            if(max<=n) {
                max = n;
            }
            if(min>=n) {
                min = n;
            }
        }

        answer+=min +" " + max;

        return answer;
    }

    public static void main(String[] args) {
        Solution solution2 = new Solution();
        String s = "-1 -2 -3 -4";
//        String s = "1 2 3 4";
        System.out.println(solution2.solution(s));
    }
}
