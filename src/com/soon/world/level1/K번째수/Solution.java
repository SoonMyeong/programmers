package com.soon.world.level1.K번째수;

import java.util.*;
/**
 * 문제 해결 과정
 * 1. commands 의 인덱스 0부터 1까지 의 값대로 array를 자른다.
 * 2. 자른 array 에서 commands 인덱스 2 번째 값을 answers 배열에 추가 한다.
 */
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int [] answers = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int cnt = commands[i][1] - commands[i][0] +1;
            int [] temp = new int[cnt];
            int n = 0;
            for(int j=commands[i][0] ; j<=commands[i][1]; j++){
                temp[n++] = array[j-1];
            }
            Arrays.sort(temp);
            answers[i] = temp[commands[i][2]-1];
        }
        return answers;
    }
}