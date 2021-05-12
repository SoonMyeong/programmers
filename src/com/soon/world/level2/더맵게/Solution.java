package com.soon.world.level2.더맵게;

import java.util.PriorityQueue;

/**
 * 힙에 관한 문제
 * 힙을 안쓸 시 (for 문 돌면서 sort 계속 할 시) 효율성에서 문제를 일으키게 된다.
 * PriorityQueue (우선순위 큐) 를 써서 해결
 */
public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int val : scoville) {
            heap.add(val);
        }

        while(heap.peek()<=K) {
            if (heap.size() == 1) {
                return -1;
            }
            int n1 = heap.poll();
            int n2 = heap.poll();

            int num = n1 + (n2 * 2);
            answer++;
            heap.add(num);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] testScoville = {1,2,3,9,10,12};
        int testK = 7;
        System.out.println(solution.solution(testScoville,testK));
    }
}
