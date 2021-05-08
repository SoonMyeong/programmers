package com.soon.world.level2.기능개발;

import java.util.*;

/**
 *  문제 해결 과정
 *  queue 를 활용 해봄
 *  1. 먼저 progresses 값은 speeds 의 값만큼 씩 계속 증가를 할테니 증가를 시켜주며 queue 에 넣어준다.
 *  2. queue 의 head 값을 조회하여 완료 되었는지 (100%) 확인 한다.
 *  3. 완료가 되지 않았을 경우 계속해서 speed 만큼 progresses 를 올려준다.
 *  4. queue 의 head 가 완료되었을 경우 큐에 데이터를 빼고, poll 한 count, 전체 cnt 를 증가 한다.
 *  5. 그 뒤 pollCount 만큼 answer 넣어 주고, 다시 pollCount 를 0으로 초기화 후, 2~4를 반복한다.
 *   -> 전체가 완료될 때 까지 (cnt == progresses.length)
 *
 */
public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] changePercent = new int[progresses.length];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int cnt = 0;

        for(int i = 0; i < progresses.length; i++) {
            changePercent[i] = progresses[i] + speeds[i];
            queue.add(changePercent[i]);
        }

        while(cnt!=progresses.length) {
            int pollCount =0;
            while (!queue.isEmpty() && queue.peek() >= 100) {
                queue.poll();
                pollCount++;
                cnt++;
            }
            queue.clear();
            for(int i=cnt; i<changePercent.length; i++){
                changePercent[i] = changePercent[i] + speeds[i];
                queue.add(changePercent[i]);
            }
            if(pollCount !=0){
                list.add(pollCount);
            }
        }
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] test = {95,90,99,99,80,99};
        int[] testSpeed = {1,1,1,1,1,1};
        Solution solution = new Solution();
        Arrays.stream(solution.solution(test,testSpeed)).forEach(System.out::println);
    }
}
