package com.soon.world.level3.디스크컨트롤러;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 3 , 3+9-1=11 , 3+9+6-2=16
 * 3, 3+6-2=7 . 3+6+9-1=17
 * 얼핏..기억에 시간 짧은거 순으로 계산하는게 가장 빠른걸로 기억 하고있음
 * -> 순차적이 아니더라도 comparable 이나 comparator 구현 해서 정렬 할 것
 * ---
 * 1. 대기작업 jobs 를 리스트에 담고 요청 시간으로 오름차순 정렬 한다.
 * 2. 가장 우선순위의 요청 시간을 기준으로 잡은 뒤 해당 시간 보다 작을 경우 우선순위 큐에 넣는다.
 * 3. 만약 우선순위 큐가 비어있다면 시간을 1씩 늘려 준다.
 * 4. 우선순위 큐에 값이 있을 경우 값을 꺼낸 뒤 현재까지의 요청시간 + 해당 값의 작업시간 - 해당 값의 요청 시간 을
 *    해 준다.
 * 2번을 생각하기가 쉽지 않았다.
 */
public class Solution {
    class Job {
        int request;
        int working;

        Job(int request, int working) {
            this.request = request;
            this.working = working;
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        LinkedList<Job> waitingJob = new LinkedList<>();
        PriorityQueue<Job> heap = new PriorityQueue<>((o1, o2) -> o1.working - o2.working);

        for(int[] el : jobs) {
            waitingJob.add(new Job(el[0],el[1]));
        }
        waitingJob.sort((o1, o2) -> o1.request - o2.request);

        int time = waitingJob.peek().request;
        int i = 0;
        while(i < jobs.length) {
            while(!waitingJob.isEmpty() && waitingJob.peek().request <= time) {
                heap.add(waitingJob.poll());
            }

            if(!heap.isEmpty()) {
                Job job = heap.poll();
                time += job.working;
                answer += time - job.request;
                i++;
            }else {
                time++;
            }

        }

        return answer/jobs.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test = {{0,3},{1,9},{2,6}};

        System.out.println(solution.solution(test));
    }
}
