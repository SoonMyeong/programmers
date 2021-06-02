package com.soon.world.review.level1.완주하지못한선수;

import java.util.*;

public class Solution {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> map = new HashMap<>();

        for(String part : participant) {
            map.put(part,map.getOrDefault(part,0)+1);
        }

        for(String com : completion) {
            map.put(com,map.get(com)-1);
        }

        for(String key : map.keySet()) {
            if(map.get(key)!=0) {
                answer = key;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] participant = {"leo","kiki","eden"};
        String[] completion = {"eden","kiki"};
        System.out.println(solution.solution(participant,completion));
    }
}
