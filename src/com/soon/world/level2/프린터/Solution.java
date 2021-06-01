package com.soon.world.level2.프린터;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * priority Queue 로 풀고싶어서 참고 한 내용
 */
public class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;

        PriorityQueue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());

        for(int task : priorities){
            priority.add(task);
        }

        // 여기 이해가 좀 어렵네
        while(!priority.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == (int)priority.peek()) {
                    if(i == location){
                        return answer;
                    }
                    priority.poll();
                    answer++;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution.solution(priorities,location));
    }
}
