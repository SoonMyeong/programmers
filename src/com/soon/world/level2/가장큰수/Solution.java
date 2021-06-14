package com.soon.world.level2.가장큰수;

import java.util.Arrays;

/**
 * compareTo 를 활용한다는게 키포인트
 */
public class Solution {

    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums,((o1, o2) -> (o2+o1).compareTo((o1+o2))));

        if (nums[0].equals("0")) {
            return "0";
        }

        String answer = "";
        for (String a : nums) {
            answer += a;
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {3,30,34,5,9};
        System.out.println(solution.solution(numbers));

    }
}
