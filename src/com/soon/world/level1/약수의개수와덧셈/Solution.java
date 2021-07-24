package com.soon.world.level1.약수의개수와덧셈;

public class Solution {

    public int solution(int left, int right) {
        int answer = 0;

        for(int i=left; i<=right; i++) {
            int count = convertDivisorCount(i);
            if(count%2==0) {
                answer += i;
            }else {
                answer -= i;
            }
        }

        return answer;
    }

    private int convertDivisorCount(int num) {
        int result = 0;
        for(int i=1; i<=num; i++) {
            if(num%i ==0) {
                result++;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int left = 13;
        int right = 17;
        System.out.println(solution.solution(left,right));
    }
}
