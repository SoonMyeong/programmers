package com.soon.world.level2.행렬테두리회전하기;

import java.util.Arrays;

public class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int cnt = 1;
        int[][] arr = new int[rows+1][columns+1];

        for(int i = 1; i<=rows; i++) {
            for(int j = 1; j<=columns; j++) {
                arr[i][j] = cnt++;
            }
        }
        cnt = 0;
        for(int[] query : queries) {
            int rowStart = query[0];
            int colStart = query[1];
            int rowEnd = query[2];
            int colEnd = query[3];

            int temp = arr[rowStart][colStart];
            int min = temp;
            //반시계 방향으로
            //왼쪽
            for(int i=rowStart; i<rowEnd; i++) {
                arr[i][colStart] = arr[i+1][colStart];
                if(min > arr[i][colStart]) {
                    min = arr[i][colStart];
                }
            }
            //아래
            for(int i=colStart; i<colEnd; i++) {
                arr[rowEnd][i] = arr[rowEnd][i+1];
                if(min > arr[rowEnd][i]) {
                    min = arr[rowEnd][i];
                }
            }
            //오른쪽
            for(int i=rowEnd; i>rowStart; i--) {
                arr[i][colEnd] = arr[i-1][colEnd];
                if(min > arr[i][colEnd]) {
                    min = arr[i][colEnd];
                }
            }
            //위
            for(int i=colEnd; i>colStart; i--) {
                arr[rowStart][i] = arr[rowStart][i-1];
                if(min > arr[rowStart][i]) {
                    min = arr[rowStart][i];
                }
            }

            arr[rowStart][colStart+1] = temp;

            answer[cnt++] = min;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        System.out.println(Arrays.toString(solution.solution(6, 6, queries)));
    }
}
