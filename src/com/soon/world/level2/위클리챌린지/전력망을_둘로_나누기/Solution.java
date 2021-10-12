package com.soon.world.level2.위클리챌린지.전력망을_둘로_나누기;


public class Solution {
    
    
    //아..이거도 아닌데
    
    static int [][] arr;
    static boolean [] visited;
    static int count = 0;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int cnt = 0;
        while(cnt<wires.length) {
            arr = new int[n+1][n+1];
            visited = new boolean[n+1];

            for(int i=cnt; i<wires.length; i++) {
                if(i!=cnt) {
                    arr[wires[i][0]][wires[i][1]] = 1;
                    arr[wires[i][1]][wires[i][0]] = 1;
                }
            }

            for(int i=1; i<=n; i++) { // 정점의 개수
                if(!visited[i]) {
                    dfs(n,i,arr, visited);
                    count++;
                }
            }
            System.out.println(count);
            count = 0;
            cnt++;
        }


        return answer;
    }

    private static void dfs(int n, int i, int[][] arr, boolean[] visited) {
        visited[i] = true;
        for(int j=1; j<=n; j++) {
            if(!visited[j]&& arr[i][j]==1) {
                dfs(n,j,arr,visited);
            }
        }
    }


    public static void main(String[] args) {
        int[][] wires = {{1,2},{2,3},{3,4}};
//        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int n = 4;
        Solution solution = new Solution();
        System.out.println(solution.solution(n,wires));

        /**
         *
         *
         */

    }
}
