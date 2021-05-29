package com.soon.world.review.level2.기능개발;

import java.util.*;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int[] change = new int[progresses.length];
        int total = 0;

        //1. 초기값 speeds 만큼 더해서 queue 에 저장
        for(int i=0; i<progresses.length; i++) {
            change[i] = progresses[i] + speeds[i];
            queue.add(change[i]);
        }

        //2. queue 의 값은 맨 앞의 값이 100이 넘을 때 100 이상의 값들을 모두 빼 주고,
        // 그만큼 count 를 늘려준다. 단, queue 에서 반복하며 빼는 갯수는 progresses 의 길이 만큼만 반복 한다.
        //2-1. 큐 맨 앞의 값이 100이 넘을 때 의 뒤의 값 역시 100이 넘어있을 가능성을 고려 하여
        //     새로운 cnt 변수를 둬서 그 갯수를 list 에 더해 준다.
        while(total!=progresses.length) {
            int pollCnt = 0;
            while(!queue.isEmpty() && queue.peek()>=100) {
                queue.poll();
                pollCnt++;
                total++;
            }
            queue.clear();

            for(int i=total; i<change.length; i++) {
                change[i] = change[i] + speeds[i];
                queue.add(change[i]);
            }

            if(pollCnt>0) {
                list.add(pollCnt);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};
        Arrays.stream(solution.solution(progresses,speeds)).forEach(System.out::println);
    }
}
