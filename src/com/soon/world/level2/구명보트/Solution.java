package com.soon.world.level2.구명보트;

import java.util.Arrays;

/**
 * 그리디 문제
 * 핵심 : (오름차순 정렬 후) 최소한의 횟수로 옮기기 위해서는 가장 몸무게가 큰 사람 + 가장 몸무게가 작은 사람 조합
 */
public class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int min = 0;
        for(int max=people.length-1; min<=max; max--) {
            if(people[min]+people[max]<=limit) {
                min++;
            }
            answer++;
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {70,50,80,50};
        int limitTest = 100;
        System.out.println(solution.solution(test,limitTest));
    }
}
