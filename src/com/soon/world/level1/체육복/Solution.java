package com.soon.world.level1.체육복;

import java.util.Arrays;

/**
 * 그리디 문제
 * 예전에 내가 푼 풀이 -> 다른사람 풀이보고 수정
 *
 */
public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] student = new int[n];

        for(int i : lost) {
            student[i-1]--;
        }
        for(int j : reserve) {
            student[j-1]++;
        }

        for(int i=0; i<student.length; i++) {
            if(student[i]==-1) {
                if (i - 1 > 0 && student[i - 1] == 1) {
                    student[i]++;
                    student[i - 1]--;
                }
                else if (i + 1 < student.length && student[i + 1] == 1) {
                    student[i]++;
                    student[i + 1]--;
                }
                else {
                    answer--;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int testNum = 5;
        int[] lostNum = {2,4};
        int[] reserveNum = {1,3,5};
        System.out.println(solution.solution(testNum,lostNum,reserveNum));
    }
}
