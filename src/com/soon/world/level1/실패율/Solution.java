package com.soon.world.level1.실패율;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * 실패율 구하기! Comparator 구현을 제외하면 거의 완전 탐색에 가깝지 않았나...
 *
 * 1. N번 스테이지까지의 실패율을 구하는 것이므로 N번 순회 한다.
 * 2. N번 순회 하면서 그 안에서 현재 스테이지에 머물러 있는 유저 수를 구한다.
 * 3. 실패율 :  count / (stage.length -personCount) 값과 현재 스테이지를 Failed 객체로 저장 후 리스트에 담는다.
 * 3-1. personCount 의 경우 현재 값 + count 값만큼 늘어난다. (예제의 경우 0, 1, 3 ...)
 * 4. 리스트를 failedScore 기준 내림차순, 값이 같을땐 stage 기준 오름차순으로 정렬 해 준다. (핵심)
 */
public class Solution {

    static class Failed {
        double failScore;
        int stage;

        Failed(double failScore, int stage) {
            this.failScore = failScore;
            this.stage = stage;
        }

        public double getFailScore() {
            return failScore;
        }

        public int getStage() {
            return stage;
        }
    }

    public int[] solution(int N, int[] stages) {
        List<Failed> failedList = new ArrayList<>();
        int[] answer = new int[N];

        int personCnt = 0;
        //1
        for(int i=1; i<=N; i++) {
            int count = 0;
            for(int j=0; j<stages.length; j++) {
                if(i==stages[j]) { //2
                    count++;
                }
            }

            double failedScore = 0;
            if(stages.length-personCnt>0) { //3
                failedScore = (double) count / (stages.length - personCnt);
            }else {
                failedScore = 0;
            }
            personCnt += count; //3-1

            failedList.add(new Failed(failedScore, i));
        }
        //4
        failedList.sort((o1, o2) -> {
            if(o1.failScore == o2.failScore) {
                return o1.stage - o2.stage;
            }
            return Double.compare(o2.failScore,o1.failScore);
        });

        return failedList.stream().mapToInt(Failed::getStage).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int [] stages = {2,1,2,6,2,4,3,3};
        System.out.println(Arrays.toString(solution.solution(n, stages)));
    }
}
