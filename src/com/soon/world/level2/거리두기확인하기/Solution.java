package com.soon.world.level2.거리두기확인하기;

import java.util.Arrays;

public class Solution {

    /**
     *
     * dfs 에서 사용하는 방문여부 파악을 preRow, preCol 로 대체 하여 풀이..!
     *
     * @param places
     * @return
     */
    static boolean result = true;

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int i=0; i<places.length; i++) {
            String[][] arr = new String[5][5];
            boolean fail = false;
            for(int j=0; j<places[i].length; j++) {
                String[] splitStr = places[i][j].split("");
                for(int k=0; k<splitStr.length; k++) {
                    arr[j][k] = splitStr[k];
                }
            }

            for(int j=0; j<arr.length; j++) {
                for(int k=0; k<arr[j].length; k++) {
                    if(arr[j][k].equals("P")) {
                        if(!calculateDistanceCheck(arr,j,k,0,j,k)) {
                            fail = true;
                            result = true;
                        }
                    }
                }
            }

            if(fail) {
                answer[i] = 0;
            }else {
                answer[i] = 1;
            }
        }


        return answer;
    }

    private boolean calculateDistanceCheck(String[][] arr,int row, int col, int depth, int preRow, int preCol) {

        if(row<4 && arr[row+1][col].equals("P")) {
            if(depth==1) {
                if(preRow!= row+1) {
                    result = false;
                }
            }else {
                result = false;
            }
        }
        if(row<4 && arr[row+1][col].equals("O")) {
            if(depth==0) {
                calculateDistanceCheck(arr,row+1,col,1,row,col);
            }
        }
        if(row>0 && arr[row-1][col].equals("P")) {
            if(depth==1) {
                if(preRow!= row-1) {
                    result = false;
                }
            }else {
                result = false;
            }
        }
        if(row>0 && arr[row-1][col].equals("O")) {
            if(depth==0) {
                calculateDistanceCheck(arr,row-1,col,1,row,col);
            }
        }



        if(col<4 && arr[row][col+1].equals("P")) {
            if(depth==1) {
                if(preCol!= col+1) {
                    result = false;
                }
            }else {
                result = false;
            }
        }
        if(col<4 && arr[row][col+1].equals("O")) {
            if(depth==0) {
                 calculateDistanceCheck(arr,row,col+1,1,row,col);
            }
        }
        if(col>0 && arr[row][col-1].equals("P")) {
            if(depth==1) {
                if(preCol!= col-1) {
                    result = false;
                }
            }else {
                result = false;
            }
        }
        if(col>0 && arr[row][col-1].equals("O")) {
            if(depth==0) {
                calculateDistanceCheck(arr, row, col-1, 1,row,col);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}
        , {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}
        , {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}
        , {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}
        , {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        System.out.println(Arrays.toString(solution.solution(places)));
    }
}
