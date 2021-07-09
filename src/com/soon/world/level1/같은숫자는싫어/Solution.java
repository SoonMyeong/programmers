package com.soon.world.level1.같은숫자는싫어;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int answerLastNumber = 0;
        list.add(arr[0]);

        for(int i=1; i<arr.length; i++) {
            if(list.get(answerLastNumber)!=arr[i]) {
                list.add(arr[i]);
                answerLastNumber++;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        Solution solution  = new Solution();
        System.out.println(Arrays.toString(solution.solution(arr)));
    }
}
