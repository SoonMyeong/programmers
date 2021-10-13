package com.soon.world.level2.위클리챌린지.전력망을_둘로_나누기;


import java.util.Arrays;

public class Solution {

    static int [][] arr;
    static boolean [] visited;
    static int count = 0;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int cnt = 0;
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }

        while(cnt<wires.length) {
            arr[wires[cnt][0]][wires[cnt][1]] = 0;
            arr[wires[cnt][1]][wires[cnt][0]] = 0;

            dfs(1,n);

            arr[wires[cnt][0]][wires[cnt][1]] = 1;
            arr[wires[cnt][1]][wires[cnt][0]] = 1;
            System.out.println(count);

            Arrays.fill(visited, false);

            /**
             * n- count 또 다른 송전탑 개수
             * 이 두개의 송전탑 개수의 차
             * n-count - count = n- 2*count
             */
            answer = Math.min(answer,Math.abs(n- (2*count)));
            count = 0;
            cnt++;
        }


        return answer;
    }

    private static void dfs(int i, int n) {
        visited[i] = true;
        count++;
        for(int j=1; j<=n; j++) {
            if(!visited[j]&& arr[i][j]==1) {
                dfs(j,n);
            }
        }
    }


    public static void main(String[] args) {
//        int[][] wires = {{1,2},{2,3},{3,4}};
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int n = 9;
        Solution solution = new Solution();
        System.out.println(solution.solution(n,wires));

        /**
         *
         *
         */

    }
}
