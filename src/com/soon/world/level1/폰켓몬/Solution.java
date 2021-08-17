package com.soon.world.level1.폰켓몬;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int solution(int[] nums) {
        int numsCount = nums.length/2;

        Set<Integer> arr = new HashSet<>();

        for(int i : nums) {
            arr.add(i);
        }

        if(arr.size()<numsCount) {
            return arr.size();
        }else {
            return numsCount;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,3,3,2,2,4};
        System.out.println(solution.solution(nums));
    }
}
