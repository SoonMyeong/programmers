package com.soon.world.review.level2.다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 기존 truck 클래스 만들고 풀던 방법 에서
 * c style 로 구현 해봄  (문제 풀이 이해를 위해..)
 *
 * 마지막 분기에서 queue 에 0 을 넣어주는 생각을 못함
 */
public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int weightCount = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int truck : truck_weights) {
            while(true) {
                if (queue.isEmpty()) {
                    weightCount += truck;
                    queue.add(truck);
                    answer++;
                    break;
                } else if (queue.size() == bridge_length) {
                    weightCount -= queue.poll();
                } else {
                    if(weightCount + truck <= weight) {
                        weightCount += truck;
                        queue.add(truck);
                        answer++;
                        break;
                    }else {
                        queue.add(0);
                        answer++;
                    }
                }
            }
        }

        return answer+bridge_length;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        System.out.println(solution.solution(bridge_length,weight,truck_weights));
    }
}
