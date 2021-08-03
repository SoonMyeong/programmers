package com.soon.world.review.level3.디스크컨트롤러;

//디스크 컨트롤러 리뷰

import sun.util.resources.cldr.sah.CalendarData_sah_RU;

import java.util.*;

/**
 * KEY POINT : 전체 걸리는 시간이 가장 짧으려면 작업시간이 짧은거 부터 처리할 경우 전체 걸리는 시간이 가장 짧다!
 * jobs 배열은 요청 시간에 맞게 오름차순 되지 않을 수도 있다! 문제 조건에 없기 때문 -> jobs 도 요청 시간에 따라 정렬 해줘야 함
 * ---------------------------------------------------------
 * 1. 처리한 jobCount 가 totalJobCount 가 될 때 까지 계속적으로 순회 한다.
 * 2. 대기중인 job 의 요청 시간이 전체 걸린 시간보다 작거나 같을 경우에만 workingJobs 에 추가 해 준다.
 *  -> 현재 처리 중인 작업 시간 내에 들어오는 요청에 대해 작업 시간이 짧은 순서로 처리 하기 위해서
 *  -> 현재 처리 중인 작업 시간 범위를 벗어난 작업이라면? 현재 진행중인 작업을 다 끝낸 이후 해당 작업 요청시간이 될때 까지 totalTime 을 +1 씩 늘려 간다.
 * 3. workingJob 에 있는 job 을 꺼내어 처리 해 준다.
 * -> 전체 걸린 시간에서 job 의 요청 시간을 빼 주면 해당 job 을 처리하는데 걸린 시간이 나온다.
 * -> 위에서 구한 처리 시간을 answer 에 추가 해준다.
 *
 */

public class Solution {

    static class Job {
        int request;
        int working;

        public Job(int request, int working) {
            this.request = request;
            this.working = working;
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        int totalJobCount = jobs.length;
        LinkedList<Job> waitingJobs = new LinkedList<>();
        PriorityQueue<Job> workingJobs = new PriorityQueue<>(Comparator.comparingInt(o -> o.working));

        for(int[]el : jobs) {
            waitingJobs.add(new Job(el[0],el[1]));
        }

        waitingJobs.sort(Comparator.comparingInt(o -> o.request));
        int totalTime = waitingJobs.get(0).request;
        int jobCount=0;

        //1
        while(jobCount<totalJobCount) {
            //2
            while(!waitingJobs.isEmpty() && waitingJobs.peek().request <= totalTime ) {
                workingJobs.add(waitingJobs.poll());
            }
            //3
            if(!workingJobs.isEmpty()) {
                Job job = workingJobs.poll();
                totalTime += job.working;
                answer += totalTime - job.request;
                jobCount++;
            }else { //2-2
                totalTime++;
            }
        }

        return answer/jobs.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] jobs = {{0,3},{1,9},{2,6}};
        System.out.println(solution.solution(jobs));
    }
}
